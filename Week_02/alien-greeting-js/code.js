/* 
Launch Academy
Assignment: Alien Greeting JS
Author: Tom Murphy
Last Edited: 2020-06-23 18:06 PT
*/

//your code here
// --- Part 1
// Write a function greet that takes an alien's name as a single, required argument. 
// It should output a greeting for the supplied name.
//
// P1 Code BEGINS Here ----------------------------------------------------------------
// let greet = (name) => {
//   return `Hi ${name}!`;
// }
// console.log(greet('ZIM'));
// P1 Code ENDS Here ------------------------------------------------------------------

// --- Part 2
// Modify your method so that it uses a random greeting among the following options below.
//   Hi [name]!
//   Yo [name]!
//   Hey [name]!
//   Howdy [name]!
//
// P2 Code BEGINS Here ----------------------------------------------------------------
// let greet = (name) => {
//   return `${['Hi','Yo','Hey','Howdy'][Math.floor(Math.random() * 4)]} ${name}!`;
// }
// console.log(greet('ZIM'));
// P2 Code ENDS Here ------------------------------------------------------------------

// --- Part 3
// Modify your method so that it takes an optional, second argument, the user's language. 
// If the second argument is not specified, the method should default to the English greeting.
// The method should support:
//   English: "Hi [name]!"
//   Spanish: "Hola [name]!"
//   Italian: "Ciao [name]!"
//   Irken: "DOOM de doom [name]!"
//
// P3 Code BEGINS Here ----------------------------------------------------------------
let greet = (name, language = 'English') => {
  let languages = ['Spanish','Italian','Irken'];
  let greetings = ['Hola','Ciao', 'DOOM de doom'];
  if (language === 'English') {return `${['Hi','Yo','Hey','Howdy'][Math.floor(Math.random() * 4)]} ${name}!`;}
  return `${greetings[languages.indexOf(language)]} ${name}!`;
}
console.log(greet('Dora'));
console.log(greet('Diego','Spanish') + '\n\n');
console.log(greet('Francis Castiglione','Italian') + '\n\n');
console.log(greet('ZIM','Irken'));
// P3 Code ENDS Here ------------------------------------------------------------------