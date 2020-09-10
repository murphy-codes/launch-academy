If you do not have it already, this is how you can get the information for the database used in this assignment. (Same database used in java-movie-trivia)

```sql
createdb movie_database
curl -o movie_database.sql.gz https://s3.amazonaws.com/launchacademy-downloads/movie_database.sql.gz
gunzip ./movie_database.sql.gz
psql movie_database
\i movie_database.sql
```

## Validating Movies

- Validate that a movie title must be between 1 and 255 characters
- Validate that a year is greater than or equal to 1920
- Validate that a rating is between 0 and 100 (allow nulls)

## Map and Validate the Studio Class

- Build out an entity that correlates with the `studios` table
- Validate that the name is present and unique

## Map and Validate the Genre Class

- Build out an entity that correlates with the `genres` table
- Validate that the name is present and unique

### Noncore - Relationships

- associate movies with their studios
- associate movies with their genre