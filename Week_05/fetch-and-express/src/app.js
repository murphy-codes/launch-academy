import express from 'express'
import logger from 'morgan'
import bodyParser from 'body-parser'
import hbsMiddleware from 'express-handlebars'
import fs from 'fs'
import _ from 'lodash'
import path from 'path'
import { fileURLToPath } from 'url'

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

const app = express()

// view engine setup
app.set('views', path.join(__dirname, '../views'))
app.engine(
  'hbs',
  hbsMiddleware({
    defaultLayout: 'default',
    extname: '.hbs'
  })
)

app.set('view engine', 'hbs')

app.use(logger('dev'))
app.use(express.json())

app.use(express.static(path.join(__dirname, '../public')))

app.listen(3000, '0.0.0.0', () => {
  console.log('Server is listening...')
})

const booksPath = path.join(__dirname, '../books.json')

const booksJson = () => {
  return JSON.parse(fs.readFileSync(booksPath))
}

const getNextBookId = () => {
  const books = booksJson()
  const maxBook = _.maxBy(books.books, book => book.id)
  return maxBook.id + 1
}

const updateBooksJsonData = books => {
  const data = { books: books }
  fs.writeFileSync(booksPath, JSON.stringify(data))
}

app.get('/', (req, res) => {
  res.render('index')
})

app.get('/test', (req, res) => {
  res.send('Hello world')
})

app.get('/test-error', (req, res) => {
  res.status(500).send('')
})

app.get('/books.json', (req, res) => {
  res.set({ 'Content-Type': 'application/json' }).json(booksJson())
})

app.post('/books.json', (req, res) => {
  console.log(req.body)
  const book = req.body.book
  if (book && book.name) {
    const newBook = {
      id: getNextBookId(),
      name: book.name
    }
    const books = booksJson().books
    books.push(newBook)
    updateBooksJsonData(books)
    res.status(201).json({ book: newBook })
  } else {
    res.status(422).json({ name: ["Can't be blank"] })
  }
})

export default app
