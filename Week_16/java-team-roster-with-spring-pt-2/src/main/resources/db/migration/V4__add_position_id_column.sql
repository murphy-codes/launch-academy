ALTER TABLE players
ADD COLUMN position_id INTEGER REFERENCES positions(id);