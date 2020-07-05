# Preflight Challenge - Comments and Variables
Let's expand on the foundations of programming with JavaScript. In this video, we explore comments, variable declaration, variable assignment, and getting input from the user with the prompt function.


# Comments, Variables, and Getting Input

## Learning Outcomes:

* Use single line and multi-line comments
* Declare and use variables in JavaScript programs
* Establish a strategy for dealing with interpreter 
  errors
* Get user input and save it in a variable

### Comments
```javascript
// This is a single line comment.

/*
   This is a 
   multi-line 
   comment. :]
*/
```

### Variables
A variable must be defined before it's referenced.

```javascript
// Statically assigned variable
let favoriteFruit = "orange";
console.log("Your favorite fruit is an " + favoriteFruit)

// Variable assigned by user input
let favoriteColor = prompt("What is your favorite color?");
console.log("To confirm, your favorite color is " + favoriteColor);
```