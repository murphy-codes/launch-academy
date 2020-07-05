// function validateYesNo(input) {
//   if(input === "yes" || input === "y" || input === "n" || input === "no") {
//     return true;
//   } else {
//     return false;
//   }
// }

function validateInput(input, acceptable) { return acceptable.includes(input); }

function validateNumInput(input) {
  if (input === NaN) {
    return false;
  } else if (input < 0){
    return false;
  } else {
    return true;
  }
}

// alert(`It's working so far!`)

// --- Part 1
// Write a program that takes in user input and prints it to the console.
// Here is what your program should do:
//     Greet the patron.
//     Ask if their order is for takeout or delivery.
//     Accept the user's answer and save it as a variable.
//     Ask how many pizzas they would like.
//     Accept the user's answer and save it as a variable.
//     Ask if they would like extra cheese added as a topping.
//     Print a sentence returning the number pizzas, if there's extra cheese, and if it's delivery or takeout.
//   Using toLowerCase() can handle for different inputs
//   Remember, there will be more than one way to successfully complete this exercise!

// P1 Code BEGINS Here ----------------------------------------------------------------
// alert("Hello hungry friend! Welcome to Doordish, where the pizza comes to you!");
// let orderType;
// do {
//     orderType = prompt("Is your order takeout or delivery?").toLowerCase();
// } while (!validateInput(orderType, ['takeout','delivery']));
// //I'm not going to validate this further at the moment, since it's not required. Normally I would.
// let numPizzas;
// do {
//     numPizzas = parseInt(prompt("How many pizzas would you like?"));
// } while (!Number.isSafeInteger(Number(numPizzas)) || numPizzas < 1);
// let extraCheese;
// do {
//     extraCheese = prompt("Would you like extra cheese?").toLowerCase();
// } while (!validateInput(extraCheese, ['y','n','yes','no']));

// noEx = (extraCheese === 'n' || extraCheese === 'no') ? 'no ' : '';
// console.log(
//     `We are preparing your ${numPizzas} pizzas with ${noEx}extra cheese to be ${(orderType === 'delivery') ? 'delivered' : 'picked up at our door'}!`
// );
// P1 Code ENDS Here ------------------------------------------------------------------



// --- Part 2
// We need to consider the fact that some folks will want delivery and need to tip.
// Update your code to prompt the user how much of a tip they want to give the driver only after they've selected delivery as their option. The user input should update the current value stored in driverTip.
//   Recall the const variable values cannot change for the life of the program. prompt stores answers as strings, and you may need to change some to fixed floats.

// P2 Code BEGINS Here ----------------------------------------------------------------
// const pizza = 15.0;
// const extraCheese = 2.0;
// const deliveryFee = 3.0;
// let driverTip = 0.0;
// alert('Hello hungry friend! Welcome to Doordish, where the pizza comes to you!');
// let orderType;
// do {
//   orderType = prompt('Is your order takeout or delivery?').toLowerCase();
// } while (!validateInput(orderType, ['t','takeout','d','delivery']));
// if (orderType === 't') {
//   orderType = 'takeout';
// } else if (orderType === 'd') {
//   orderType = 'delivery';
// }
// if (orderType === 'delivery') {
//   do {
//     driverTip = parseFloat(prompt('How much do you want to tip the driver?'));
//   } while (!validateNumInput(driverTip));
//   driverTip = parseFloat(driverTip.toFixed(2));
// }
// let numPizzas;
// do {
//   numPizzas = parseInt(prompt('How many pizzas would you like?'));
// } while (!Number.isSafeInteger(Number(numPizzas)) || numPizzas < 1);
// let exCheese;
// do {
//   exCheese = prompt('Would you like extra cheese?').toLowerCase();
// } while (!validateInput(exCheese, ['y','n','yes','no']));
// noEx = (exCheese === 'n' || exCheese === 'no') ? 'no ' : '';
// console.log(
//   `We are preparing your ${numPizzas} pizzas with ${noEx}extra cheese to be ` + 
//   `${(orderType === 'delivery') ? 'delivered' : 'picked up at our door'}!`
// );
// P2 Code ENDS Here ------------------------------------------------------------------



// --- Part 3
// We need to be sure we aren't giving away free cheese! Add in some code that updates the price based on whether or not they ordered extra cheese. Extra cheese is charged PER PIZZA ordered.

// P3 Code BEGINS Here ----------------------------------------------------------------
// const pizza = 15.0;
// const extraCheese = 2.0;
// const deliveryFee = 3.0;
// let driverTip = 0.0;
// alert('Hello hungry friend! Welcome to Doordish, where the pizza comes to you!');
// let orderType;
// do {
//   orderType = prompt('Is your order takeout or delivery?').toLowerCase();
// } while (!validateInput(orderType, ['t','takeout','d','delivery']));
// if (orderType === 't') {
//   orderType = 'takeout';
// } else if (orderType === 'd') {
//   orderType = 'delivery';
// }
// if (orderType === 'delivery') {
//   do {
//     driverTip = parseFloat(prompt('How much do you want to tip the driver?'));
//   } while (!validateNumInput(driverTip));
//   driverTip = parseFloat(driverTip.toFixed(2));
// }
// let numPizzas;
// do {
//   numPizzas = parseInt(prompt('How many pizzas would you like?'));
// } while (!Number.isSafeInteger(Number(numPizzas)) || numPizzas < 1);
// let exCheese;
// do {
//   exCheese = prompt('Would you like extra cheese?').toLowerCase();
// } while (!validateInput(exCheese, ['y','n','yes','no']));
// let price;
// if (exCheese === 'y' || exCheese === 'yes') {
//   price = (numPizzas * (pizza + extraCheese) + driverTip).toFixed(2);
// } else {
//     price = (numPizzas * pizza + driverTip).toFixed(2);
// }
// noEx = (exCheese === 'n' || exCheese === 'no') ? 'no ' : '';
// console.log(
//   `Your total comes to \$${price} for this order.\n\n` + 
//   `We are preparing your ${numPizzas} pizzas with ${noEx}extra cheese to be ` + 
//   `${(orderType === 'delivery') ? 'delivered' : 'picked up at our door'}!`
// );
// P3 Code ENDS Here ------------------------------------------------------------------



// --- Part 4
// Finally, we need to print an itemized receipt that includes a summary of the order and the total order cost.

// P4 Code BEGINS Here ----------------------------------------------------------------
const pizza = 15.0;
const extraCheese = 2.0;
const deliveryFee = 3.0;
let driverTip = 0.0;
let price = 0.0;
let bonuses;
let wholeDollar = true;
alert('Hello hungry friend! Welcome to Doordish, where the pizza comes to you!');
let orderType;
do {
  orderType = prompt('Is your order takeout or delivery?').toLowerCase();
} while (!validateInput(orderType, ['t','takeout','d','delivery']));
if (orderType === 't') {
  orderType = 'takeout';
} else if (orderType === 'd') {
  orderType = 'delivery';
}
if (orderType === 'delivery') {
  console.log(`The delivery fee is $${deliveryFee}.`);
  do {
    driverTip = parseFloat(prompt('How much do you want to tip the driver?'));
  } while (!validateNumInput(driverTip));
  driverTip = parseFloat(driverTip.toFixed(2));
  price += deliveryFee + driverTip;
  if (driverTip > 0) {
    let decimal = driverTip - Math.floor(driverTip);
    if (decimal > 0) {
      bonuses = `With a $${driverTip.toFixed(2)} tip and a delivery fee, y`;
      wholeDollar = false;
    } else {
      bonuses = `With a $${parseInt(driverTip)} tip and a delivery fee, y`;
    }
  } else {
    bonuses = 'With a delivery fee, y';
  }
} else {
    bonuses = 'Y';
}
let numPizzas;
do {
  numPizzas = parseInt(prompt('How many pizzas would you like?'));
} while (!validateNumInput(numPizzas) || numPizzas < 1);
let exCheese;
do {
  exCheese = prompt('Would you like extra cheese?').toLowerCase();
} while (!validateInput(exCheese, ['y','n','yes','no']));
if (exCheese === 'y' || exCheese === 'yes') {
  console.log(`Extra cheese on ${(numPizzas > 1) ? `${numPizzas} pizzas` : `${numPizzas} pizza`} will cost you an additional $${parseInt((numPizzas*extraCheese).toFixed(2))}.`);
  price += parseFloat((numPizzas * (pizza + extraCheese)));
} else {
    price += parseFloat((numPizzas * pizza));
}
let noEx = (exCheese === 'n' || exCheese === 'no') ? 'no ' : '';
console.log(
  `We are preparing your ${(numPizzas > 1) ? `${numPizzas} pizzas` : `${numPizzas} pizza`} with ${noEx}extra cheese to be ` + 
  `${(orderType === 'delivery') ? 'delivered' : 'picked up at our door'}! ` + 
  `${bonuses}our total comes to $${(!wholeDollar) ? parseFloat(price).toFixed(2) : price} for this order.`
);
// P4 Code ENDS Here ------------------------------------------------------------------