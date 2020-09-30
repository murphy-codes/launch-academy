Here at Launch, we're a big fan of parties - spontaneous dance parties, board game nights, karaoke parties, puppy parties (which is mostly just something we wish was a very common type of party), the list goes on! We need help keeping track of all of these parties, and all of the wonderful friends we want to invite to each of them.

## Introduction

You'll be building a website that helps us manage our invitation lists, letting us create events, keep track of all of our friends, list which friends we want to invite to each of our parties, and even let our friends leave RSVPs on the page for us!

Party Planner is primarily focused on various aspects of Spring, and the end result will be a full-fledged, database-backed web application!

Note: This challenge is a **longer, more comprehensive project** than some of the ones you may have worked on to date, so you can expect to spend several such coding sessions working through it. Full web applications are usually not built in a day, so take your time with this challenge.

This assignment will pull together many of the key concepts that we have covered to date in a way that starts to simulate the real-world experience of a professional web developer.

### Getting Started

When tackling any sizable body of work, it's important to break down that work into manageable chunks. To guide your progress, we've split out the work into three parts, with each part focusing on a different aspect of Migrations, Associations, and Validations.

As a rough guideline, you can expect each part to require the time and effort of one "normal" challenge.

Be sure to review the lessons on the relevant topics before diving into the work itself, and reference them as you go along.

To get started, run:

```no-highlight
et get java-party-planner
cd java-party-planner
idea .
```

### A Guide to Each Day

To start each day, read through all of the core user stories and instructions for that day to learn about what the app should do (both through the user experience, and behind the scenes).

For each user story, you will want to think about how to design and set up the schema for the app. You will need to plan out what tables you need, and what columns each one should have. Use a tool like [draw.io](https://www.draw.io/) to create/update an ER diagram for your schema.

When your ER diagram is finished for the day, create the migrations required to set up your database. Create a related Entity for each table you add to your database, so that you can use a Repository to access your data. These models should be saved under a `models` namespace.

## User Stories

### Core User Stories

Each section contains user stories and acceptance criteria, with further instructions at the bottom of the section.

#### Part 1: Viewing and Creating Parties

```no-highlight
As a party planner
I want to view a list of all parties I'm planning
So that I can figure out who might be interested in joining me for each
```

Acceptance Criteria:

- If I go to the root path, I should be redirected to `/parties`.
- On the parties index page at `/parties`, I should see the name of each party.
- Each of the parties should be parties retrieved from my database.

```no-highlight
As a party planner
I want to view the details of a party
So that I can learn more about what fun is planned
```

Acceptance Criteria:

- On the parties index page, the name of each party should be a link to the party's show page.
- On the show page, I should see the name, description, and location of the party.

```no-highlight
As a party planner
I want to create a party
So that I can plan all the fun things I want to do
```

Acceptance Criteria:

- There should be a link from the parties index page that takes you to the parties new page. On this page there is a form to create a new party.
- I must supply a name, location, and description of the party.
- If the form submission is successful, I should be brought to the party's show page.

#### Viewing and Creating Friends

```no-highlight
As a party planner
I want to view a list of all of my friends
So I can see how popular I am
```

Acceptance Criteria:

- On the friends index page at `/friends`, I should see the first and last name of each of my friends.
- Friends should be listed alphabetically by first name.

```no-highlight
As a party planner
I want to add new friends to my friends list
So that I can invite them to all of my parties
```

Acceptance Criteria:

- There should be a link from the friends index page that takes you to the friends new page. On this page there is a form to create a new friend.
- I must supply a first and last name for my friend.
- If the form submission is successful, I should be brought back to the friends index page.
