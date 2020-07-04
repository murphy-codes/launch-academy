let supplies = ["space helmet", "canister of oxygen", "water recycler", "big red button", "freeze dried ice cream", "tang drink mix"];

// 1.)  Using a `forEach` loop, write a function called `supplyCheck` that takes in an array of supplies as an argument, and logs each item to your console. It should match the message of "SUPPLY ITEM is logged and accounted for."
function supplyCheck(inventory) {
  inventory.forEach(element => console.log(`${element} is logged and accounted for.`));
}
supplyCheck(supplies);
console.log("\n");

// 2.) Create a function named stowSupplies that takes in our array of supplies, and returns item name and its index number in a formatted string.
// function stowSupplies(inventory) {
//   inventory.forEach(element => console.log(`${element} is in locker ${index}.`));
// }
function stowSupplies(element, index) {
  console.log(`${element} is in locker ${index+1}.`);
}
supplies.forEach(stowSupplies);
console.log("\n");


// 3.) Create a function named addAlphabetically that takes in our array of supplies and a new supply item and returns an array of supplies with that new item, sorted alphabetically.
function addAlphabetically(inventory, newItem) {
  inventory.push(newItem);
  inventory.sort();
  return inventory;
}
addAlphabetically(supplies, "camera");
console.log(supplies);

// 4.) Create a function named stockCheck that takes in an inventory checklist array, and an array of supplies, and returns an array of items that are missing from the checklist.
let inventoryChecklist = ["big red button", "canister of oxygen", "freeze dried ice cream", "jetpack", "tang drink mix", "space helmet", "space brussels sprouts", "water recycler", "welding torch"];
function stockCheck(checklist, inventory) {
  return checklist.filter(item => !inventory.includes(item));
}
console.log(stockCheck(inventoryChecklist, supplies));
missingSupplies = stockCheck(inventoryChecklist, supplies);

// 5.) Create a function named addMissingSupplies that takes in an array of supplies, and an array of missing supplies, and returns a new array with all of the items combined! Use your stockCheck method to help you with this.
function addMissingSupplies(incompleteArray, missingElements) {
  return incompleteArray.concat(missingElements);
}
console.log(addMissingSupplies(supplies, missingSupplies));