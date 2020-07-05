/*
# Bank Balance

We're going to build a program over two days. 

Your first assignment is to write a program that:

- asks the user for their current bank balance
- if the user enters a negative number, 
  or something that is not a number, 
  prompt them again for a valid number
*/

let bankBalance = parseFloat(prompt("What's your bank balance?"));
while (isNaN(bankBalance) || bankBalance < 0)  {
  bankBalance = parseFloat(prompt(
    "Please input a valid, non-negative number.\n\n" + 
    "What's your bank balance?"));
}
alert(`Your balance is: $${bankBalance.toFixed(2)}!`);