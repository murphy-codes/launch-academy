/* 
Launch Academy
Assignment: Checkout Line JS
Author: Tom Murphy
Last Edited: 2020-06-23 22:46 PT
*/

let eggs = {
  itemName: 'dozen eggs',
  quantity: 2,
  price: 0.99
}

let milk = {
  itemName: 'gallon of milk',
  quantity: 1,
  price: 2.99
}

let bread = {
  itemName: 'loaf of bread',
  quantity: 1,
  price: 3.50
}

let coffee = {
  itemName: 'lbs. of coffee',
  quantity: 10,
  price: 8.99
}

let shoppingCart = [eggs, milk, bread, coffee]

let toCurrency = (amount) => {
  return parseFloat(amount.toFixed(2));
}

let getPrice = (item) => {
  return item.price;
}

let getQuantity = (item) => {
  return item.quantity;
}

let coffeeItem = shoppingCart.find(item => item.itemName === 'lbs. of coffee');
let milkItem = shoppingCart.find(item => item.itemName === 'gallon of milk');

console.log(`One lb. of coffee is $${getPrice(coffeeItem)}.`);
console.log(`The shopping cart has ${getQuantity(milkItem)} gallon(s) of milk in it.`);

let taxRate = 6.25;
let subTotal = 0;

shoppingCart.forEach((item) => {
  subTotal += getPrice(item) * getQuantity(item);
})

let tax = subTotal * taxRate/100;
console.log(`\n------ Receipt ------`);
console.log(`  Subtotal:  $${subTotal}`);
console.log(`       Tax:   $${toCurrency(tax)}`);
console.log(`     Total: $${toCurrency(subTotal + tax)}`);