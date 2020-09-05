#### In This Article

In this article, you will find the answers to these questions

* What should my group accomplish by the **afternoon of Day 1**?
* How should we plan our app?
* What procedures (pull requests, question queue, etc.) should we follow as we move forward?

For the exact expectations and parameters of this assignment, see the [Node Group Project](/lessons/node-group-project) article

### Introduction

During this challenge, you'll build a web application in a group of developers.
The major goals for the week are:

* To touch on several of the key features of basic Node apps, such as CRUD functionality and building out internal APIs.
* To utilize your understanding of React.js to create a seamless front-end experience for users.
* To learn how to collaborate on an app and use git workflows.

This project will require you to learn how to work as a part of a team. The EEs will observe and assist you as managers and will require you to practice good team workflow, including agile methodology (in the form of daily stand-up and stand-down meetings), git version control, user stories, and acceptance criteria.

**Expect this week to be challenging!** Collaboration can be tough, both organizationally and personally. Treat this project as an opportunity to strengthen your communication and organizational skills.
Employers value developers who can communicate well with others and are patient and good-natured with their team members.

#### MUST Do Before Day 1 Stand Down

##### Setting up your Team

* Select a note-taker for the day
-*[Create your Private group Slack channel](https://get.slack.help/hc/en-us/articles/201402297-Create-a-channel) (different from a group DM!) and add all EEs
  * We encourage you to come up with a clever name for your group
* Decide together what kind of pets your site will have
* Create an ER diagram
* Have your note-taker post a picture of your diagram in your group slack channel

##### Create Your App

On one person's machine...

* Create your database:

```no-highlight
  et get node-group-project
  mkdir <your_app_name_here>
  mv node-group-project ./<your_app_name_here>
  cd <your_app_name_here>
  yarn install
  createdb <db_name>
  update your `server.js` to ensure that your connection string reflects the DB name you intend to use
```

* Edit the `README.md` to include the name and a brief description of the project as well as a list of all the authors.
* Don't do any further work on your app yet!

##### Create Your Repo

On that same person's machine...

* Create a repository on Github, add all group members and all EEs as collaborators, and push your starting code ("initial commit") up to the remote repo following GitHub's instructions.
  * Pat: prohetsfall
  * Brianna: bkincart
  * Dan: danAlberts

On each other person's machine...

* **Clone** (do not fork or download as a zip) the remote repo to set up a local copy of the code.Click on the green button that says Code and copy the Repo URL

```bash
git clone <repo_url>
cd <repo_name>
yarn install
createdb adopt_a_pet<data_base_name>
```

##### Check Your Environment

On each person's machine...

Ensure that the correct postgres username and password are set up for the connection string (for most users this is `postgres` and `password` respectively).

#### Planning Your App

After morning standup, you will get to work on your project! You'll find that the first step is to plan out your first few features. Remember to follow the roadmapping steps you were introduced to earlier in the curriculum! Refer to the [Roadmapping a Challenge](/lessons/roadmapping-a-challenge) and [User Stories and Acceptance Criteria](/lessons/user-stories-and-acceptance-criteria) articles when organizing your features.

You may also choose to use a Trello board, shared Google doc, or some other kind of organizational tool for assigning and keeping track of tasks.

#### Daily Procedure

**Please read this section carefully and refer to it often! Take following these instructions as seriously as you would if this were an actual workplace.**

##### Morning Stand-Up and Notes

Adhering to Agile methodologies, you are to have a stand-up meeting each morning at a time agreed to by your group prior to 11AM EST/8AM PST).
You will select a note-taker for the day, discuss what you accomplished the previous day, and state your goals for the day.
*Your note-taker should then post your stand-up notes in your Slack channel by 11:30AM EST/830AM PST each morning*.

An example of good stand-up notes is below:

```no-highlight
Yesterday:
- Brianna and Nick worked on adding images to the pet show page.
  - They got stuck on getting the image to render, and will be talking to AmyLynn for some tips from her prior project.
- AmyLynn and Dan worked on adding the adoption request review form.

Today:
- Brianna and Nick will finish up implementing the images.
- AmyLynn and Dan will move on to adding the api endpoint for the adoption request form.

We are a bit behind the suggested schedule on the show page for our pets, but we hope to be caught up by the end of today!
```

##### Proper Feature Workflow

Once you have a team plan for the day, make sure you are following proper team workflow to get your features shipped! A step-by-step guide to each new feature is found in the `node-group-project` article. Note that these steps should be followed together for EACH feature (for example, **one branch or PR should include _one_ feature**, such as "submitting an adoption request" or "pet show page"). You can find some more detailed examples in the [Pull Request Workflow Practice](/lessons/pull-request-workflow-practice-js) article.

* Read the user story
* Discuss the acceptance criteria and how best to implement them
* Check out a new branch for your feature.
* Write the code for your feature.
* Commit your changes and push your branch up to Github.
* On Github, create a Pull Request.
* Make sure that your code adheres to style guides (proper spacing, no partial code, no extraneous comments, no `console.log`s unless they serve a real purpose, and no `debugger`s).
* Copy the PR link and post in the questions channel tagging your PR manager for the shift.
* If you run into questions, add a Question Queue question with **all required information** (including code snippets, steps this far, and error message text).

##### Dealing with Project Blockers

There will be times when you're waiting on your manager to resolve a QQ question or merge a PR request. The beauty of the git workflow and good planning is that, for the most part, you should be able to organize your branches so that you can work on additional features while waiting.

However, sometimes you may have a PR waiting for review or a question in the queue that is blocking your progress on **all other features**.
It is extremely important to learn how to properly communicate this to your manager! You will only want to communicate in this way when you have truly hit a standstill: we don't want any situations of the wolf who cried "boy" 😉.

When posting a question or PR which is fully blocking your group, be sure to tag your PR Manager in Slack with a note indicating that this issue is blocking your team's progress forward and why.
This way, your PR manager will know where to best focus their time to help you move forward productively!
