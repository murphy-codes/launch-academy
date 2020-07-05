// A loaf of bread: $1.99
// A gallon of milk: $3.89
// One dozen eggs: $2.29

let breadPrice = 1.99;
let milkPrice = 3.89;
let eggsPrice = 2.29;

let totalCost = breadPrice + milkPrice + eggsPrice;

console.log("Under normal conditions...");
console.log("Your total cost is: $" + totalCost);

// Severe Conditions!
// We have a Nor'easter sweeping through that's going to leave us under three-stories of snow!

// Our precious French Toast ingredients are now three times the original price, but nothing will stop us from making our beloved breakfast!

// Write some JavaScript code to calculate the cost of purchasing French Toast ingredients at 3x the market rate.

let totalCostNoreaster = parseFloat((3 * totalCost).toFixed(2));

console.log("\nHowever, with a Nor'easter sweeping through everyone has panic-bought most of the ingredients. Due to a limited supply, the price of our Frech-toast ingredients have tripled!");
console.log("Your total cost is: $" + totalCostNoreaster);