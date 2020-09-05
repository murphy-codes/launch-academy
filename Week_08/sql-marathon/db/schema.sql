-- DROP TABLE IF EXISTS movies;
-- DROP TABLE movies CASCADE;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  category VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE movies (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  year INTEGER NOT NULL,
  category_id INTEGER REFERENCES categories(id),
  UNIQUE (title, year)
);