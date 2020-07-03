/*
# Coin Flip Challenge

- write a program that randomly selects heads or tails. 
- There should be approximately a 50% chance that you'll 
  get either heads or tails

## BONUS Challenge: 

- prompt the user to call "heads" or "tails"
- inform the user whether they've won or lost the coin toss
  based on the random result
*/

let coin = Math.floor(Math.random() * 2);
let userGuess = prompt("What do you think it will be: heads or tails?");
if (
  (userGuess === "heads" && coin === 0) || 
  (userGuess === "tails" && coin === 1)
  ) {
  alert(`Correct! The coin landed on ${userGuess}!`);
} else {
  alert(`Sorry, but the coin landed on ${(coin === 0) ? "heads" : "tails"}!`);
}