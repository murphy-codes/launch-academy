  CREATE TABLE players (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  position VARCHAR(255) NOT NULL,
  team_id INTEGER REFERENCES teams(id)
);