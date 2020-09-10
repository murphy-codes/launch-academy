CREATE table categories(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  UNIQUE(name)
);

CREATE table products(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price FLOAT,
  featured boolean,
  description text,
  category_id int REFERENCES categories(id)
);
