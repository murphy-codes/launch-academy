-- Write a SQL statement that selects all of the movies before the year 2000.
SELECT title AS movies_before_2000, year FROM movies WHERE year < 2000;

-- Write a query to view all categories
SELECT category FROM categories;

-- Write a SQL query to get the movie with id of 4.
SELECT title AS the_4th_movie, year FROM movies WHERE id = 4;

-- Write a SQL query to order movie titles by year in ascending order. Then modify the SQL query to print out all movies in alphabetical order, grouped by year.