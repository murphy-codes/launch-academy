CREATE table blasters(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT null,
  recharge_time INTEGER not null,
  attachment VARCHAR(255)
);