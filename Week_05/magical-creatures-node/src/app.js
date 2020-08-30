import createError from 'http-errors'
import express from 'express'
import path from 'path'
import logger from 'morgan'
import bodyParser from 'body-parser'
import expressSession from 'express-session'
import fs from 'fs'
import flash from 'flash'
import hbsMiddleware from 'express-handlebars'
import { fileURLToPath } from 'url';

const app = express()

const __dirname = path.dirname(fileURLToPath(import.meta.url));

const fields = ['title', 'url', 'description']

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
app.use(
  expressSession({
    secret: 'Launch Academy',
    resave: false,
    saveUninitialized: true,
    cookie: { secure: false }
  })
)

app.use(flash())

// flush session
app.use((req, res, next) => {
  if (req.session && req.session.flash && req.session.flash.length > 0) {
    req.session.flash = []
  }
  next()
})

app.use(express.static(path.join(__dirname, '../public')))
app.use(bodyParser.urlencoded({ extended: true }))

// Our MagicalCreature class ... does stuff
import MagicalCreature from './MagicalCreature.js'

//YOUR CODE BELOW
app.get('/', async (req, res) => {
  res.render('index');
});

app.get('/creatures', async (req, res) => {
  res.render('creatures', {creature: MagicalCreature.findAll()});
});

app.get('/creatures/:creature', async (req, res) => {
  const creature = req.params.creature[0].toUpperCase() + req.params.creature.slice(1).toLowerCase();
  let creatureType = MagicalCreature.find(creature);
  if (creatureType) {
    if (creatureType.isAncient()) {creatureType.age = "Ancient"};
    res.render('type', creatureType);
  } else {
    res.status(404).render('404', {error: `Creature "${creature}"`});
  };
});

app.get('/:page', async (req, res) => {
  res.status(404).render('404', {error: `Page "${req.params.page}"`});
});

app.get('/*', async (req, res) => {
  res.status(404).render('404', {error: `Page`});
});

export default app