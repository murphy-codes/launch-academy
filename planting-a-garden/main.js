/* 
Launch Academy
Assignment: Planting a Garden
Author: Tom Murphy
Last Edited: 2020-06-23 11:12 PT
*/

allSeeds = [
  "arugula",
  "kale",
  "romaine",
  "iceberg",
  "beet",
  "potato",
  "carrot",
  "garlic",
  "onion",
  "strawberry",
  "raspberry",
  "blackberry",
  "blueberry",
  "roma tomato",
  "acorn squash",
  "ugly tomato",
  "cherry tomato",
  "butternut squash",
  "jalapeno pepper",
  "cayenne pepper",
  "banana pepper",
  "poblano pepper"
]

fruits = [
  "strawberry",
  "raspberry",
  "blackberry",
  "blueberry",
  "roma tomato",
  "ugly tomato",
  "acorn squash",
  "cherry tomato",
  "butternut squash",
  "jalapeno pepper",
  "cayenne pepper",
  "banana pepper",
  "poblano pepper"
]

vegetables = [
  "beet",
  "potato",
  "carrot",
  "garlic",
  "onion"
]

leafyGreens = [
  "arugula",
  "kale",
  "romaine",
  "iceberg"
]

myGarden = []
// We love making homemade sauce (or gravy) for pasta dinners. Let's write a line of code to return every kind of tomato seed you can order from the allSeeds array, then add those seed names to the array myGarden.
//return allSeeds.filter(item => item.toLowerCase().includes("tomato"));
myGarden = myGarden.concat(allSeeds.filter(item => item.toLowerCase().includes("tomato")));
console.log(myGarden);

// We love having fresh berries on our yogurt. Write a line of code to return every berry seed in the allSeeds array, then add those seed names to the array myGarden.
//return allSeeds.filter(item => item.toLowerCase().includes("berry"));
myGarden = myGarden.concat(allSeeds.filter(item => item.toLowerCase().includes("berry")));
console.log(myGarden);

// We are very picky when it comes to our pepper preferences. Write a line of code that will return every pepper in the allSeeds array that does NOT have the word "cayenne" in it. Also add those names to myGarden.
//return allSeeds.filter(item => (item.toLowerCase().includes("pepper") && !item.toLowerCase().includes("cayenne")));
myGarden = myGarden.concat(allSeeds.filter(item => (item.toLowerCase().includes("pepper") && !item.toLowerCase().includes("cayenne"))));
console.log(myGarden);

// To make searching easier, we want to see an alphabetized list of available seeds. Write a line of code that will return an alphabetized list of all the seeds available, but does not include any of the seeds currently inside myGarden.
// return allSeeds.filter(item => !myGarden.includes(item)).sort();
let unpurchased = allSeeds.filter(item => !myGarden.includes(item)).sort();
console.log(unpurchased);

// Looking at the current list of fruits is bothering you. You know that a tomato is a fruit, but you want it to be a vegetable. Write some code that removes all the tomatoes, peppers, and squash from the fruits array and adds them to the vegetables array.
let naughtFruits = fruits.filter(item => (item.toLowerCase().includes("tomato") || item.toLowerCase().includes("pepper") || item.toLowerCase().includes("squash")));
fruits = fruits.filter(item => !naughtFruits.includes(item));
vegetables.concat(naughtFruits);
console.log(naughtFruits);

// Iceberg lettuce is the worst kind of lettuce, and we all know it. Write some code that deletes that option from all of the arrays that contain it.
[allSeeds, fruits, vegetables, leafyGreens].forEach(produceArray => (produceArray.includes("iceberg") ? produceArray.splice(produceArray.indexOf("iceberg"), 1) : ""));
console.log(allSeeds);
console.log(leafyGreens);

// You don't have room to plant more than one kind of squash, but you're not too picky. Use a function to return the first squash found in the allSeeds array, then add that to myGarden.
let findSquash = (seeds) => {
  return seeds.find(seed => seed.toLowerCase().includes("squash"));
}
myGarden.push(findSquash(allSeeds));
console.log(myGarden);

// We've lost track of what we want to order. Write some code that logs each item from your myGarden array, then tells you how many plants you've selected in total.
//myGarden = myGarden.sort();
console.log(`There are ${myGarden.sort().length} seeds I wish to plant in my garden.`)
function logSeeds(element, index) {
  console.log(`Seed ${index+1}: ${element}`);
}
myGarden.forEach(logSeeds);