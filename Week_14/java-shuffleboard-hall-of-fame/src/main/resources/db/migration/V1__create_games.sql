DROP TABLE IF EXISTS games;

CREATE TABLE games (
  id SERIAL PRIMARY KEY,
  red_team_player_1 VARCHAR NOT NULL,
  red_team_player_2 VARCHAR NOT NULL,
  red_team_score INTEGER NOT NULL,
  blue_team_player_1 VARCHAR NOT NULL,
  blue_team_player_2 VARCHAR NOT NULL,
  blue_team_score INTEGER NOT NULL
);