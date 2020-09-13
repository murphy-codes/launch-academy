CREATE TABLE laser_cannons(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  recharge_time INTEGER NOT NULL,
  fire_rate INTEGER NOT NULL
);