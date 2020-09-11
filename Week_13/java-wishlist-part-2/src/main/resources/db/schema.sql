CREATE table categories(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  UNIQUE(name)
);

CREATE table products(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price FLOAT,
  url VARCHAR(255) NOT NULL,
  category_id int REFERENCES categories(id)
);