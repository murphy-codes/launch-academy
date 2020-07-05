/* 
Launch Academy
Assignment: grocery-list-array
Author: Tom Murphy
Last Edited: 2020-06-21 21:03 PT
*/

// You're going to the grocery store and decide to use an array to keep track of your shopping list.
// Write a program in code.js that:
// 01. Creates an array to represent your shopping list with the following items: 'pop tarts', 'ramen noodles', 'chips', 'salsa', and 'coffee'.
// 02. Adds 'fruit loops' to the list.
// 03. Updates 'coffee' to 'fair trade coffee'
// 04. Replaces 'chips' and 'salsa' with 'rice' and 'beans'
// 05. Creates an empty array to represent your shopping cart.
// 06. Removes the last item from your shopping list and add it to your cart
// 07. Removes the first item from your shopping list and add it to the cart
// 08. Writes a 'while' loop that takes items from your shopping list and 
//     moves them to your cart until there are no items left on the list.
// 09. Sorts the items in your cart alphabetically... backwards
// 10. Prints the list of items in your shopping cart to the console as a 
//     comma separated string.

const shoppingList = ['pop tarts', 'ramen noodles', 'chips', 'salsa', 'coffee'];
shoppingList.push('fruit loops');
shoppingList[shoppingList.indexOf('coffee')] = 'fair trade coffee';
shoppingList.splice(shoppingList.indexOf('chips'), 2, 'rice', 'beans');
const shoppingCart = [];
shoppingCart.push(shoppingList.pop());
shoppingCart.push(shoppingList.shift());
while (shoppingList.length > 0) {
  shoppingCart.push(shoppingList.pop());
}
shoppingCart.sort().reverse();
console.log(shoppingCart.join(','));  