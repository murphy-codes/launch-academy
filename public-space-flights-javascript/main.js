/*
Here is what your program should do:
    Greet the customer.
    Ask how many adult tickets they would like.
    Accept the user's answer and save it as a variable.
    Ask how many child tickets they would like.
    Accept the user's answer and save it as a variable.
    Print a sentence returning the number of adult and child tickets the user has asked for.
*/

// Your code here!
const dehydratedBanana = 1.27
const tofuCake = 4.17
const cheeseSpread = 3.79
const dehydratedIceCreamSandwich = 0.75

// console.log(`It's working so far!`)

console.log('Hello brave customer! Welcome to our exclusive space flight tours.')

let numAdultTickets = prompt("How many adult tickets would you like?");
let numChildTickets = prompt("How many child tickets would you like?");
console.log("Here are your " + numAdultTickets + " adult tickets and " + numChildTickets + " child tickets!");

/*
Print each answer to the console.
    Two tofu cakes and two dehydrated ice cream sandwiches
    Eight cheese spreads and a dehydrated banana
    Three of each item on the menu
*/

console.log('\nTwo tofu cakes and two dehydrated ice cream sandwiches cost $' + ((2*tofuCake)+(2*dehydratedIceCreamSandwich)));
console.log('Eight cheese spreads and a dehydrated banana cost $' + ((8*cheeseSpread)+dehydratedBanana));
console.log('Three of each item on the menu cost $' + (3*(dehydratedBanana+tofuCake+cheeseSpread+dehydratedIceCreamSandwich)));