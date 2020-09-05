NASA is about to throw an epic "launch" party, and has tasked you with creating an epic party playlist. The rocket itself will contain all of the necessary equipment for their new moon base, but it will all be for nothing unless they have the right tunes to celebrate with!

## Getting Started

```no-highlight
et get party-playlist-persistence
cd party-playlist-persistence
yarn install
createdb party-playlist
psql party-playlist

party-playlist=# \i db/schema.sql
```

***HINT: You may need to downgrade to Node 12.18.3 for this assignment***

A schema has been provided for you. Take a quick look at `db/schema.sql` to acquaint yourself. The index page for all of our party playlist songs has also been constructed for you, and a user can view the current list of songs by navigating to `/songs`.

Your task is to correctly configure the app to allow a user to add all of the songs for our launch party and view them in the app. Specifically, you'll need to set up the routes for `GET` `/songs/new` and `POST` `/songs`, as well as the template that holds the form.

Note: You can optionally run this sql command in `psql` to seed a song:

```SQL
INSERT INTO songs (title, song_length, artist) VALUES
('Fly Me to the Moon', '2:27', 'Frank Sinatra');
```

## User Stories

### Add a Song

Acceptance Criteria

* Navigating to `/songs/new` presents the user with a form to add a new song. The form should allow a user to designate the title, song_length (string), artist and album for a song.
* Submitting the form with all required fields filled out persists the song in the database via `POST` request to `/songs`
* The user is redirected to the `/songs` index page when the form has been submitted correctly. The newly persisted song should appear on the page.
* If the user submits the form without all required fields, the `/songs/new` page should be re-rendered with error messages telling the user which fields cannot be blank (only the `album` field should be optional).

### Non-Core

* If the form is filled out incorrectly, it should be re-rendered with pre-filled values that correspond to what they had previously entered.
* Normalize your database by creating a new `artists` table in your database that forms a one-to-many relationship with the `songs` table respectively. Your app should still satisfy all of the core acceptance criteria, but submitting the form should add a new value to both the `songs` table and `artists` table with your new song information. This may require nesting or chaining promises.
