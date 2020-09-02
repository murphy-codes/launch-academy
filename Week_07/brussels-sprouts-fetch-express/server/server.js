import express from "express"
import path from "path"
import { fileURLToPath } from 'url'
import logger from "morgan"
import bodyParser from "body-parser"
import hbsMiddleware from "express-handlebars"
import fs from "fs"

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

const app = express()

app.use(logger("dev"))
app.use(express.json())

app.use(express.static(path.join(__dirname, "../public")))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

app.get("/", (req, res) => {
  res.render("index")
})

app.get("/api/v1/recipes", (req, res) => {
  const jsonString = fs.readFileSync(path.join(__dirname, "../dishes.json")).toString()
  res.json(JSON.parse(jsonString))
})

app.get("/api/v1/random-recipe", (req, res) => {
  const jsonString = fs.readFileSync(path.join(__dirname, "../dishes.json")).toString()
  const jsonParsed = JSON.parse(jsonString)
  res.json(jsonParsed[Math.floor(Math.random()*jsonParsed.length)])
})

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

export default app
