import path from "path"
import { fileURLToPath } from 'url'
import logger from "morgan"
import bodyParser from "body-parser"
import hbsMiddleware from "express-handlebars"
import fs from "fs"
import _ from "lodash"
import express from "express"

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

const app = express()

app.set("views", path.join(__dirname, "../views"))
app.engine(
  "hbs",
  hbsMiddleware({
    extname: ".hbs"
  })
)

app.set("view engine", "hbs")

app.use(logger("dev"))
app.use(express.json())

app.use(express.static(path.join(__dirname, "../public")))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

const skillsPath = path.join(__dirname, "../skills.json")
const loadSkills = () => {
  return JSON.parse(fs.readFileSync(skillsPath))
}

const eduPath = path.join(__dirname, "../education_experiences.json")
const loadEdu = () => {
  return JSON.parse(fs.readFileSync(eduPath))
}

const projectsPath = path.join(__dirname, "../projects.json")
const loadProjects = () => {
  return JSON.parse(fs.readFileSync(projectsPath))
}

const volunteeringPath = path.join(__dirname, "../volunteer_experiences.json")
const loadVolunteeringExperiences = () => {
  return JSON.parse(fs.readFileSync(volunteeringPath))
}

const workPath = path.join(__dirname, "../work_experiences.json")
const loadWorkExperiences = () => {
  return JSON.parse(fs.readFileSync(workPath))
}

const renderHome = (req, res) => {
  res.render("home")
}

app.get("/", renderHome)
app.get("/projects", renderHome)
app.get("/projects/:id", renderHome)
app.get("/resume", renderHome)

app.get("/api/v1/skills.json", (req, res) => {
  res.json(loadSkills())
})

app.get("/api/v1/work_experiences.json", (req, res) => {
  res.json(loadWorkExperiences())
})

app.get("/api/v1/education_experiences.json", (req, res) => {
  res.json(loadEdu())
})

app.get("/api/v1/volunteer_experiences.json", (req, res) => {
  res.json(loadVolunteeringExperiences())
})

app.get("/api/v1/projects.json", (req, res) => {
  res.json(loadProjects())
})

app.get("/api/v1/projects/:id", (req, res) => {
  const project = loadProjects().find(project => project.id == req.params.id)
  if(project) {
    res.json(project)
  }
  else {
    res.status(422)
  }
})

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

export default app
