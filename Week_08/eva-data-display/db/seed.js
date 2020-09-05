import pg from 'pg'
import { fileURLToPath } from 'url'
import path from 'path'
import LineReader from "line-reader"

const pool = new pg.Pool({
  connectionString: "postgres://postgres:password@127.0.0.1:5432/nasa"
});

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)
