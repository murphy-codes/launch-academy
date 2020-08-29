console.log("Step 01 ----------------------------------------");
// An element with an id of i-love-educated-lizards
console.log(document.getElementById("i-love-educated-lizards"));

console.log("\nStep 02 ----------------------------------------");
// All elements with a class of recipe-idea
let allRecipeIdeas = document.getElementsByClassName("recipe-idea")
console.log(allRecipeIdeas)

console.log("\nStep 03 ----------------------------------------");
// Using the result from #2, access the second element with this class
console.log(allRecipeIdeas[1])

console.log("\nStep 04 ----------------------------------------");
// All <div> elements
console.log(document.getElementsByTagName("div"));

console.log("\nStep 05 ----------------------------------------");
// All <h2> elements with a class of lyrics
console.log(document.querySelector("h2.lyrics"));

console.log("\nStep 06 ----------------------------------------");
// The parent of the element whose id is purple-jaguar-eye
console.log(document.getElementById("purple-jaguar-eye").parentElement);

console.log("\nStep 07 ----------------------------------------");
// The children of the element whose id is purple-jaguar-eye
let childrenOfThePurpleJaguarEye = document.getElementById("purple-jaguar-eye").children;
console.log(childrenOfThePurpleJaguarEye);

console.log("\nStep 08 ----------------------------------------");
// Using the result from #7, the sixth child of that element
console.log(childrenOfThePurpleJaguarEye[5]);

console.log("\nStep 09 ----------------------------------------");
// The element with classes of both recipe-idea and intentional-misspelling-of-desert (using just one line of code)
console.log(document.getElementsByClassName("recipe-idea intentional-misspelling-of-desert")[0]);

console.log("\nStep 10 ----------------------------------------");
// Tell me how many elements are children of the element with an id of limerickroll
let rickDadstley = document.getElementById("limerickroll");
console.log(rickDadstley ? `The element w/ ID "limerickroll" has ${rickDadstley.children.length} children.` : `There is no element w/ the ID "limerickroll", but there are ${document.getElementsByClassName("limerickroll")[0].children.length} children of the first element with a class of "limerickroll".`);