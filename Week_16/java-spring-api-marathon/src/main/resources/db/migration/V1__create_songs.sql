DROP TABLE IF EXISTS songs;

CREATE TABLE songs (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(255),
  release_year INTEGER NOT NULL,
  explicit_content BOOLEAN NOT NULL
);