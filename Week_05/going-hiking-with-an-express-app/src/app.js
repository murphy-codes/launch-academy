import express from "express"
import path from "path"
import logger from "morgan"
import bodyParser from "body-parser"
import hbsMiddleware from "express-handlebars"
import fs from "fs"

const app = express()


const suppliesPath = (new URL('../supplies.txt', import.meta.url)).pathname

// view engine setup
app.set("views", (new URL('../views', import.meta.url)).pathname)
app.engine(
  "hbs",
  hbsMiddleware({
    defaultLayout: "default",
    extname: ".hbs"
  })
)
app.set("view engine", "hbs")

app.use(logger("dev"))
app.use(express.json())

app.use(express.static((new URL('../public', import.meta.url)).pathname))
app.use(bodyParser.urlencoded({ extended: true }))

app.get("/", (req, res) => {
  const supplies = fs
    .readFileSync(suppliesPath)
    .toString()
    .split("\n")
  //remove the blank new line at the end of the file
  supplies.pop()
  res.render("index", { supplies: supplies })
})

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

export default app
