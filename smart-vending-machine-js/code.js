/* 
Launch Academy
Assignment: Smart Vending Machine JS
Author: Tom Murphy
Last Edited: 2020-06-21 19:41 PT
*/


// PART 1
// Ask the user what vending machine item they would like.
// Accept the user answer and save it as a variable.
// Ask the user how many of the vending machine item they would like.
// Accept the user's answer (should be a number) and save it as a variable
// Use the answer to start a while loop, in which you print the word the user asked for, the number of times that they specified.


// P1 Code BEGINS Here ----------------------------------------------------------------
// function validateNumInput(input) {
//   if (input === NaN) {
//     return false;
//   } else if (input < 0){
//     return false;
//   } else {
//     return true;
//   }
// }

// console.log("Hello, I'm the first and only Talking Vending Machine.");
// let itemRequested = prompt("What would you like today?");
// let amountRequested;
// do {
//   amountRequested = parseInt(prompt("How many of those would you like?"));
// } while (!validateNumInput(amountRequested))
// while (amountRequested > 0) {
//   console.log(itemRequested);
//   amountRequested--;
// }
// console.log("There you go! Come again!");
// P1 Code ENDS Here ------------------------------------------------------------------


// --- Part 2
// Instructions & stuff...
// Next, we want to add one more feature to our vending machine in which a user can ask for 
// "tons" of something as an amount, and get a random amount of whatever they asked for. 
// Modify your program so it achieves the following:
// 1.  Start by going through the same steps as above.
// 2.  When the user is asked how many things they would like, if they say "tons", 
//     print the vending machine item the user requested a random number of times less than 20.

// P2 Code BEGINS Here ----------------------------------------------------------------
// function validateAmount(input) {
//   if (input === "tons") {
//     return true;
//   } else if (parseInt(input) === NaN) {
//     return false;
//   } else if (input < 0){
//     return false;
//   } else {
//     return true;
//   }
// }

// console.log("Hello, I'm the first and only Talking Vending Machine.");
// let itemRequested = prompt("What would you like today?");
// let amountRequested;
// do {
//   amountRequested = prompt("How many of those would you like?");
// } while (!validateAmount(amountRequested))
// if (amountRequested === "tons") {
//   amountRequested = Math.ceil(Math.random() * 19);
// }
// while (amountRequested > 0) {
//   console.log(itemRequested);
//   amountRequested--;
// }
// console.log("There you go! Come again!");
// P2 Code ENDS Here ------------------------------------------------------------------


// --- Part 3
// Some of your space explorers are getting so excited by the prospect of getting "tons" 
// of food that they aren't following our rules very well, and typing invalid input like 
// "I want tons!!!!!" when asked how many items they want. Let's modify our program so that 
// instead of needing to type the word "tons" exactly, a user can now type the word "tons" 
// anywhere in their answer to get the same result as described in Part 2.
// Modify your program to check if the user input contains the string "tons".

// P3 Code BEGINS Here ----------------------------------------------------------------
function validateAmount(input) {
  if (parseInt(input) === NaN) {
    return false;
  } else if (input < 0){
    return false;
  } else {
    return true;
  }
}

console.log("Hello, I'm the first and only Talking Vending Machine.");
let itemRequested = prompt("What would you like today?");
let amountRequested;
do {
  amountRequested = prompt("How many of those would you like?");
  if (amountRequested.toLowerCase().includes("tons")) {
    amountRequested = Math.ceil(Math.random() * 19);
  }
  amountRequested = parseInt(amountRequested); // this line is actually unnecessary because of how forgiving Javascript is with string 'numbers'
} while (!validateAmount(amountRequested))
while (amountRequested > 0) {
  console.log(itemRequested);
  amountRequested--;
}
console.log("There you go! Come again!");
// P3 Code ENDS Here ------------------------------------------------------------------