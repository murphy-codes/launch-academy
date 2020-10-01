CREATE TABLE friends (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL
);

CREATE TABLE parties (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  location VARCHAR(255) NOT NULL
);

CREATE TABLE attendances (
  id SERIAL PRIMARY KEY,
  friend_id INTEGER REFERENCES friends(id),
  party_id INTEGER REFERENCES parties(id)
);