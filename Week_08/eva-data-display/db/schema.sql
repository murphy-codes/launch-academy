-- Create a crew_members table. This should have a primary key and name of the crew member.


-- Create a crew_members table. This should have a primary key, country, vehicle, occurred_on, duration_hours, duration_minutes, and purpose





-- this is only for non-core
-- Create an excursion_participants table. It should relate a crew_member to an excursion. 
-- Note: this table is a join table, and it's primary purpose is to keep track of a relationship between a crew member and an exercusion. 
-- As such, it should contain a primary key, and foriegn key columns for both crew_member id and excursion id

-- CREATE TABLE excursion_participants (
--   id SERIAL PRIMARY KEY,
--   crew_member_id INTEGER references crew_members(id),
--   excursion_id INTEGER references excursions(id)
-- );

-- Modify your seed script so that there is a unique list of names in crew_members for each crew member found in eva-data.csv. 

-- Your seed script should populate the excursion_participants table so that excursions and crew members are properly related.