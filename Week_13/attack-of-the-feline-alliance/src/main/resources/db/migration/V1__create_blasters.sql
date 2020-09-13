CREATE TABLE blasters(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  recharge_time INTEGER NOT NULL,
  attachment VARCHAR(255)
);