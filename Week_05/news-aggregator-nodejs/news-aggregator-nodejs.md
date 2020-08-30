It's important to stay connected with what's going on in the world (even if that means spending hours scouring reddit or news forums rather than accomplishing anything productive). Let's build a news aggregator so we can share some pointless articles and help others waste time effectively.

### Learning Objectives

* Build a NodeJS application that receives user input via HTTP POST requests.
* Persist user data on the server by writing to JSON documents.
* Make use of the HandleBars JS library for templating dynamic web pages.

### Getting Setup

```no-highlight
et get news-aggregator-nodejs
cd news-aggregator-nodejs
yarn install
yarn run dev
```

### Overview

News Aggregator is an app where a user can view a list of articles and add to an existing list of articles. In this assignment, data will be maintained and persisted in the `articles.json` file provided in the root of your app. The code below shows how one can interact with an `articles.json` file in your `app.js`:

```js
// path to your articles.json file
const articlesPath = path.join(__dirname, "../articles.json")

// read from the articles.json file
const articlesJson = () => {
  return JSON.parse(fs.readFileSync(articlesPath))
}

// add to the articles.json file.
const updateArticlesJsonData = (newArticleObject) => {
  const articles = articlesJson().articles
  articles.push(newArticleObject)

  const data = { articles }
  fs.writeFileSync(articlesPath, JSON.stringify(data))
}
```

* `articlesPath` is a helper method to designate the path for our `articles.json` file
* `articlesJson` retrieves the current list of articles and returns them as an object with a key of `articles`. Make sure to examine this returned object closely so that you can use it correctly in Handlebars. Remember that a single key means the key and the value are the same variable (as in `{ articles: articles }`).
* `updateArticlesJsonData` takes an article object (that have keys of title, url and description) and persists it to the `articles.json` file.

##### Important Tips:

* In order to use `updateArticlesJsonData()` correctly, you will need to retrieve params and prepare an object to be passed to the method.
* A URL is valid if it begins with `http://` or `https://`.

### Instructions

Build a web application for news articles using NodeJS and Express that displays a list of articles that users have submitted.

The application should satisfy the following user stories:

#### Articles Index Page
```no-highlight
As a procrastinator
I want to be able to visit a page that shows me all the submitted articles
So that I can procrastinate
```

Acceptance Criteria:

* When I visit `/articles` I should be able to see all the articles that have been submitted.
* Each article should show the description, title, and URL.
* If I click on the URL it should take me to the website designated inside of a new tab.

```no-highlight
As a procrastinator
I want to be able to submit an incredibly interesting article
So that other procrastinators may benefit
```

#### New Article Page

Acceptance Criteria:

* When I visit `/articles/new` it has a form to submit a new article.
* The form accepts an article title, URL, and description.
* When I successfully post an article, it should be saved to a JSON file.

### Optional User Stories

For an extra **optional** challenge, implement the following additional user stores.

_Only tackle these additional user stories if you have completed the Core User Stories._ You may choose any order in which to approach these stories, but the order in which they appear is suggested.

The optional JavaScript user stories require that you first read material concerning Fetch and Promises in JavaScript. Don't tackle these stories unless you have done so.

#### Retrieving a Random Article with Fetch

```no-highlight
As a web-surfing procrastinator
I want to see a random article
So that I can spend less time choosing which article to read
```

Acceptance Criteria:

* When I visit `/random` it has a button with the text "Random Button".
* When the button is clicked, a fetch call generates a request to an API endpoint on the Sinatra backend
* The API endpoint returns a random article as a response, and that article's information will need to append to the page.

Tips:
* You may wish to review past JavaScript DOM manipulation assignments in order to recall how to manipulate the DOM with JS on the front end and add JS event handlers.
* You'll need to a folder titled `public` in the root of your application. That folder should also have a `js` folder in it e.g. `public/js`. This folder is where you should keep the JavaScript file that will run on your page e.g. `public/js/client.js`.
* In your JavaScript file, you'll want to add an event listener that will trigger your fetch request.
* Upon a successful fetch request, you will need to write JavaScript code that will append your article information to an element on the DOM
* In order to have that JavaScript run on your page, you will need to add a script tag to the bottom of the `random.hbs` template that you create.

```html
<script src="/js/app.js"></script>
```

* Use your new CSV skills to retrieve a random article from your `articles.csv`. Ensure that you use the proper syntax for returning json data instead of HTML in your endpoint:


```js
app.get("/articles.json", (req, res) => {

  // retrieve a random article object

  res.set({ "Content-Type": "application/json" }).json(<INSERT-THE-JSON-OBJECT-YOU-WISH-TO-RETURN>)
})
```

#### Error Handling

```no-highlight
As an errant procrastinator
I want to receive an error message
When I submit an invalid article
```

Acceptance Criteria:

* If I do not specify a title, URL, and description, I receive an error message, and the submission form is re-rendered with the details I have previously submitted.
* If I specify an invalid URL, I receive an error message, and the submission form is re-rendered with the details I have previously submitted.
* If I specify a description that doesn't have 20 or more characters, I receive an error message, and the submission form is re-rendered with the details I have previously submitted.
* The submitted article is not saved in any of the above cases.

```no-highlight
As a plagiarizing procrastinator
I want to receive an error message
When I submit an article that has already been submitted
```

Acceptance Criteria:

* If I specify a URL that has already been submitted, I receive an error message, and the submission form is re-rendered with the details I have previously submitted.
* The submitted article is not saved in the above case.

#### Using a Article class to help manage your data

**Define an `Article` class that has the following aspects:**

- takes in a `title` as an argument, a `url` as a second argument, and an `description` as an optional third argument

*Note: The class file for this feature has already been created and imported*.

```js
import Article from "./models/Article.js"
```

You will need to edit this file and use it to complete this feature. You may have to restart your server between edits for your changes to take effect.

**Use your `Article` class in your application**

- Create a static method `.findAll()` on the `Article` class that reads from the `articles.json` and returns an Article object for each of our articles. Ensure that this method is being called when a user navigates to `/articles` to populate the article objects sent to your handlebars template.

- Create a static method `.create(newArticleObject)` on the `Article` class that takes an un-persisted article object and adds it to the `articles.json` file. Ensure that this method is being called when a user submits a form on the new article page.
