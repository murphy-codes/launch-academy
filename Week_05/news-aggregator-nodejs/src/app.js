import createError from "http-errors"
import express from "express"
import logger from "morgan"
import bodyParser from "body-parser"
import expressSession from "express-session"
import hbsMiddleware from "express-handlebars"
import fs from "fs"
import flash from "flash"
import handlebarHelpers from "./handlebars/helpers/index.js"
// import debugFunc from "debug"
import Article from "./models/Article.js"
import path from "path"
import { fileURLToPath } from "url"

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

// const appName = "news-aggregator"
// const debug = debugFunc(`${appName}:server`)

const app = express()

// view engine setup
app.set("views", path.join(__dirname, "../views"))
app.engine(
  "hbs",
  hbsMiddleware({
    defaultLayout: "default",
    helpers: handlebarHelpers,
    extname: ".hbs"
  })
)
app.set("view engine", "hbs")

app.use(logger("dev"))
app.use(express.json())
app.use(
  expressSession({
    secret: "Launch Academy",
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

app.use(express.static(path.join(__dirname, "../public")))
app.use(bodyParser.urlencoded({ extended: true }))

const fields = ["title", "url", "description"]

// path to your articles.json file
const articlesPath = path.join(__dirname, "../articles.json")

// read from the articles.json file
const articlesJson = () => {
  return JSON.parse(fs.readFileSync(articlesPath))
}

// add to the articles.json file.
const updateArticlesJsonData = (newArticleObject) => {
  const articles = articlesJson().articles
  articles.push(newArticleObject)

  const data = { articles }
  fs.writeFileSync(articlesPath, JSON.stringify(data))
}

// standard routes below
// #####################

app.get("/", async (req, res) => {
  res.redirect("articles");
})

app.get("/articles", async (req, res) => {
  res.render("articles/index", { articles: articlesJson().articles });
})

app.get("/articles/new", async (req, res) => {
  res.render("articles/new", { fields });
})

app.post("/articles/new", async (req, res) => {
  updateArticlesJsonData(req.body);
  res.redirect("/articles");
})

app.get("/random-article", async (req, res) => {
  res.render("articles/random-article", articlesJson().articles[Math.floor(Math.random() * Math.floor(articlesJson().articles.length))]);
})

app.get("/random", async (req, res) => {
  res.render("articles/random");
})

app.get("/articles.json", async (req, res) => {
  res.set({ 'Content-Type': 'application/json' }).json(articlesJson())
})

// catch 404 and forward to error handler
app.use((req, res, next) => {
  next(createError(404))
})

// error handler
app.use((err, req, res) => {
  // set locals, only providing error in development
  res.locals.message = err.message
  res.locals.error = req.app.get("env") === "development" ? err : {}

  // render the error page
  res.status(err.status || 500)
  res.render("error")
})

export default app