# Preflight Challenge - Flow Control
Our programs become more interesting when they make decisions for us. In this video, we'll explore boolean expressions and flow control with conditional statements.

This video discusses how an if/else block can be used to adjust the behavior of our program based on boolean expressions. It also discussed logical operators, specifically || (OR) and && (AND) operators. Lastly, we discussed generating random numebrs with Math.random().

```javascript
let favoriteFood = prompt("What is your favorite food?")
if (favoriteFood === "pizza") {
  console.log("The ninja turtles agree!")
} else {
  console.log("Ok.")
}

let aFavoriteFood = "soda"

if (aFavoriteFood === "soda" || aFavoriteFood === "beer") {
  console.log("That's not healthy. Also, that's not really a food!")
}

if (aFavoriteFood !== "spinach" && aFavoriteFood !== "green beans") {
  console.log("You should like healthy things")
} else {
  console.log("Good! That's eating healthy")
}

console.log(Math.random())
```