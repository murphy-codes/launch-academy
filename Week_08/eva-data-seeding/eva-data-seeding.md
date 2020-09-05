In this exercise, we'll take NASA's Extra-vehicular Activity (EVA) activity data and place it in a database for later use.

## Getting Started

```no-highlight
et get eva-data-seeding
cd eva-data-seeding
nvm use 12 (on mac) nvm use 12.18.3 (on pc)
yarn install
```

## Build the Schema

You're tasked with designing the schema for housing [NASA's EVA Data](https://data.nasa.gov/Raw-Data/Extra-vehicular-Activity-EVA-US-and-Russia/9kcy-zwvn).

```no-highlight
createdb nasa
```

Write and execute the Schema (DDL) in the provided `schema.sql` file.

You should have a single `excursions` table. It should have the following columns with appropriate data types:

- country (VARCHAR)
- crew (VARCHAR)
- vehicle (VARCHAR)
- occurred_on (DATE)
- duration_hours (INT)
- duration_minutes (INT)
- purpose (TEXT)

After loading your `schema` you can verify that it has worked by connecting to the database and describing the table.

```no-highlight
$ psql nasa
nasa=# \d excursions
```

Once you've confirmed that the schema loaded it's time to populate it with data! Write a script in `db/seed.js` to load the data into your new database! To achieve this you will need to load the data from the supplied `eva-data.csv` file. You will also need to use `LineReader` and `pool.query` to complete this step.

You may receive the message when running your seed file:
>(node:75367) ExperimentalWarning: The ESM module loader is experimental.

This is expected due to using ESM modules on Node 12.

Verify your data has loaded by connecting to the nasa database `$ psql nasa` and running `SELECT * FROM excursions;`

Thanks to your efforts NASA can now launch their first crewed mission to Pluto, to answer the question once and for all... Is Pluto a planet?
