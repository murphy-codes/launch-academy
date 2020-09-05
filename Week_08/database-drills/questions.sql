-- ---------- Retrieval ------------------------------------------------------------
-- • What titles were released in 2003?
SELECT title, year FROM movies WHERE year = 2003;
-- • What titles were released in 2004 and had a rating higher than 90?
SELECT title, year, rating FROM movies WHERE year = 2004 AND rating > 90;
-- • What actors have the last name of Wilson?
SELECT name  FROM actors  WHERE name LIKE '% Wilson';
-- • What actors have the first name of Owen?
SELECT name  FROM actors  WHERE name LIKE 'Owen %';
-- • What studios start with "Fox"?
SELECT name  FROM studios  WHERE name LIKE 'Fox%';
-- • What studios involve Disney?
SELECT name  FROM studios  WHERE name LIKE '%Disney%';
-- • What were the top 5 rated movies in 2005?
SELECT title, year, rating FROM movies WHERE year = 2005 AND rating > 90 ORDER BY rating DESC LIMIT 5;
-- • What were the worst 10 movie titles and their ratings in 2000?
SELECT title, year, rating FROM movies WHERE year = 2000 ORDER BY rating LIMIT 10;
-- ---------- Advanced Retrieval ------------------------------------------------------------
-- • What movie titles were produced by Walt Disney Pictures in 2010?
SELECT title, year, name AS studio FROM movies 
INNER JOIN studios ON studio_id = studios.id 
WHERE year = 2010 AND name = 'Walt Disney Pictures';
-- • Who were the characters in "The Hunger Games"?
SELECT character, title FROM cast_members 
INNER JOIN movies ON movies.id = movie_id 
WHERE title = 'The Hunger Games' AND character IS NOT NULL;
-- • Who acted in "The Hunger Games"?
SELECT name, character, title FROM actors 
INNER JOIN cast_members ON actors.id = actor_id 
INNER JOIN movies ON movie_id = movies.id 
WHERE title = 'The Hunger Games';
-- • Who acted in a Star Wars movie? Be sure to include all movies.
SELECT name, character, title FROM actors 
INNER JOIN cast_members ON actors.id = actor_id 
INNER JOIN movies ON movie_id = movies.id 
WHERE title LIKE '%Star Wars%';
-- • What were all of the character names for movies released in 2009?
SELECT character, title, year FROM cast_members
INNER JOIN movies ON movie_id = movies.id 
WHERE year = 2009;
-- • What are the character names in the "The Dark Knight Rises"?
SELECT character, title FROM cast_members 
INNER JOIN movies ON movies.id = movie_id 
WHERE title = 'The Dark Knight Rises' AND character IS NOT NULL;
-- • What actors and actresses have been hired by Buena Vista?
SELECT actors.name as Performer FROM actors 
INNER JOIN cast_members ON actors.id = actor_id 
INNER JOIN movies ON movie_id = movies.id 
INNER JOIN studios ON studio_id = studios.id 
WHERE studios.name = 'Buena Vista';
  -- WHERE studios.name LIKE 'Buena Vista%';
-- ---------- Updating ------------------------------------------------------------
-- • Troll 2 was the best movie ever. Let's update it to have a rating of 500.
UPDATE movies SET rating = 500, updated_at = NOW() WHERE title = 'Troll 2';
  -- SELECT title, rating, updated_at FROM movies WHERE title = 'Troll 2';
-- • "Police Academy 4 - Citizens on Patrol" was underrated. Let's give it a 20.
UPDATE movies SET rating = 20, updated_at = NOW() WHERE title = 'Police Academy 4 - Citizens on Patrol';
  -- SELECT title, rating, updated_at FROM movies WHERE title = 'Police Academy 4 - Citizens on Patrol';
-- • Matt Damon has updated his name to "The Artist Formerly Known as Matt Damon". Let's update the database to reflect this momentous change in the film industry.
UPDATE actors SET name = 'The Artist Formerly Known as Matt Damon', updated_at = NOW() WHERE name = 'Matt Damon';
-- SELECT name, updated_at FROM actors WHERE name LIKE '%Matt Damon%';
-- ---------- Deletion ------------------------------------------------------------
-- • We want to forget Back to the Future Part III ever happened. Delete only that movie. Be sure to delete correlating cast_member entries first.
DELETE FROM cast_members AS cm USING movies AS m WHERE cm.movie_id = m.id AND m.title = 'Back to the Future Part III';
DELETE FROM movies WHERE title = 'Back to the Future Part III';
-- SELECT character, title FROM cast_members INNER JOIN movies ON movies.id = movie_id WHERE title = 'Back to the Future Part III';
-- SELECT title, rating, updated_at FROM movies WHERE title = 'Back to the Future Part III';
-- • Horror movies are too scary - delete every Horror movie. Don't forget about their correlating cast_members entries.
DELETE FROM cast_members cm USING movies AS m, genres AS g WHERE cm.movie_id = m.id  AND m.genre_id = g.id AND g.name = 'Horror';
DELETE FROM movies AS m USING genres AS g WHERE m.genre_id = g.id AND g.name = 'Horror';
-- SELECT COUNT(character) FROM cast_members INNER JOIN movies ON movie_id = movies.id INNER JOIN genres ON genre_id = genres.id WHERE genres.name = 'Horror';
-- SELECT COUNT(title) AS genre FROM movies INNER JOIN genres ON genre_id = genres.id WHERE genres.name = 'Horror';



-- • Ben Affleck movies are also too scary - delete every movie he acted in. Wasn't that therapeutic?
-- • Fake news - we're revising history for 20th Century Fox. Delete any movie they produced that has a rating of less than 80.
-- ---------- Schema ------------------------------------------------------------
-- • We're creating a reviews table so that we can store individual movie reviews. The table should have a description, score from 0-100, author name, and it should relate to a movie. Create the DDL necessary to create this table.
-- • We're creating a crimes table for all crimes actors or actresses commit. It should include the year of offense, the title of the offense, and it should relate to the actor. Create the DDL necessary to create this table.