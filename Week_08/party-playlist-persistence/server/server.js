import path from "path"
import logger from "morgan"
import bodyParser from "body-parser"
import hbsMiddleware from "express-handlebars"
import fs from "fs"
import _ from "lodash"
import express from "express"
import pg from "pg"
import { fileURLToPath } from 'url'

const app = express()


const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

app.set("views", path.join(__dirname, "../views"))
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

app.use(express.static(path.join(__dirname, "../public")))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

const pool = new pg.Pool({
  connectionString: "postgres://postgres:password@127.0.0.1:5432/party-playlist"
})

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

app.get("/songs", (req, res) => {
  pool.connect().then(client => {
    client.query("SELECT * FROM songs").then(result => {

      const songs = result.rows

      client.release()

      res.render("songs", { songs: songs })
    })
  })
})

app.get("/songs/new", (req, res) => {
  // res.render("songs/new")
  res.render("songs/new", { song: {} })
})

app.post("/songs", (req, res) => {
  // res.render("songs/new", { song: {}, errors: ["Title can't be blank","Track duration can't be blank","Artist can't be blank"] })
  const song = req.body.song
  //get the properties of song
  const { title, song_length, artist, album } = song

  //initialize a list of errors, then check for blank submissions on required fields
  const errors = []
  if (!title || title === "") {
    errors.push("Title can't be blank")
  }
  if (!song_length || song_length === "") {
    errors.push("Track duration can't be blank")
  }
  if (!artist || artist === "") {
    errors.push("Artist can't be blank")
  }
  if (errors.length === 0) {
    pool
      .query(
        "INSERT INTO songs (title, song_length, artist, album) VALUES ($1, $2, $3, $4)",
        [song.title, song.song_length, song.artist, song.album]
      )
      .then(result => {
        res.redirect("/songs")
      })
      .catch(err => {
        console.log(err)
        res.sendStatus(500)
      })
  } else {
    //re-render the form and give the user a chance to fix things
    // res.render("/songs/new", { song: song, errors: errors })
    res.render("songs/new", { song: song, errors: errors })
  }
})

export default app
