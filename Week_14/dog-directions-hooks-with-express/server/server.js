import express from "express"
import path from "path"
import logger from "morgan"
import bodyParser from "body-parser"
import fs from "fs"
import { fileURLToPath } from 'url'
// import _ from "lodash"
// import hbsMiddleware from "express-handlebars"

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

const app = express()

app.use(logger("dev"))
app.use(express.json())

app.use(express.static(path.join(__dirname, "../public")))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

app.get("/", (req, res) => {
  res.send("Hello from the backend")
})

app.get("/api/v1/favoriteThings.json", (req, res) => {
  const jsonString = fs.readFileSync(path.join(__dirname, "../favoriteThings.json")).toString()
  res.json(JSON.parse(jsonString))
})

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

export default app
