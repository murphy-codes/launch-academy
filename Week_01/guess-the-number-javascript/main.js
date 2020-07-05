// Generate a random number between 1 and 10
let randDigit = Math.floor(Math.random() * 10) + 1;
console.log(randDigit);

// Get the user's name
let userName = prompt("What is your name?");
// if (userName == null) {username = ''};
while (userName == null) {
  userName = prompt("What is your name?");
}

// Ask the user to enter a number
let userNum = Number(prompt("Choose a number between 1-10! (inclusive)"));
while (!Number.isSafeInteger(Number(userNum)) || userNum < 1 || userNum > 10) {
  userNum = Number(prompt("Choose a number between 1-10! (inclusive)"));
}
console.log(userNum);

// If the number equals the random number let the user know that they've won, otherwise let them know that they lost
if (userNum == randDigit) {
    alert("Congratulations " + userName + "! You've won the raffle!");
} else {
    alert("Sorry " + userName + ", you didn't win. Better luck next time!");
}