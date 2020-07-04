/* 
Launch Academy
Assignment: JavaScript Function Drills
Author: Tom Murphy
Last Edited: 2020-06-26 22:27 PT
*/

import {swap, partition, quickSort} from './quicksort.js'

let nonNegative = (number) => {
  if (number >= 0) {
    return true;
  }
  return false;
};

let divisibleByFive = (number) => {
  if (number%5 === 0) {
    return true;
  }
  return false;
};

let lastNameFirstName = (firstName, lastName) => {
  return `${lastName}, ${firstName}`;
};

let summation = (n) => {
  return n*(n+1) / 2;
};

let foundInStr = (char, str) => {
  let [count,i] = [0,0];
  while (str.slice(i).includes(char)) {
    count++;
    i = str.indexOf(char);
    str = str.slice(i+1);
  };
  return count;
};

let sortNumbers = (unsorted) =>{
  return unsorted.sort((a, b) => (a-b));
}; // Via https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort#Description & Ria's submitted solution

let spamWord = (num, word) => {
  let phrase = "";
  for (let i=0; i<num; i++) {
    phrase += `${word} `;
  };
  return phrase.trim();
};

let toSeconds = (minutes) => {
  return parseInt(minutes)*60;
};

let firstAndLast = (inputArray) => {
  return [inputArray[0],inputArray[inputArray.length-1]];
};

let birthstones = new Map([
  ["January", "Garnet"],
  ["February", "Amethyst"],
  ["March", "Aquamarine"],
  ["April", "Diamond"],
  ["May", "Emerald"],
  ["June", "Alexandrite"],
  ["July", "Ruby"],
  ["August", "Peridot"],
  ["September", "Sapphire"],
  ["October", "Pink Tourmaline"],
  ["November", "Topaz"],
  ["December", "Blue Topaz"]
]);

let getBirthstone = (month) => {
  if (birthstones.has(month)) {
    return birthstones.get(month);
  }
  return "none";
};

// STEP 1
console.log(`Check if 5 is non negative: ${nonNegative(5)}`); // => true
console.log(`Check if -5 is non negative: ${nonNegative(-5)}\n`); // => false
// STEP 2
console.log(`Check if 5 is divisible by 5: ${divisibleByFive(5)}`); // => true
console.log(`Check if 71 is divisible by 5: ${divisibleByFive(71)}\n`); // => false
// STEP 3
console.log(lastNameFirstName("Islay", "Mae")); // => "Mae, Islay"
console.log(lastNameFirstName("Fred","Rogers") + "\n"); // => "Rogers, Fred"
// STEP 4
console.log(summation(3)); // => 6
console.log(summation(4) + "\n"); // => 10
// STEP 5
console.log(foundInStr("a", "Islay Mae")); // => 2
console.log(foundInStr("x", "Geoffrey") + "\n"); // => 0
// STEP 6
console.log(`sortNumbers([47, 89, 12, 3, 6]) = [${sortNumbers([47, 89, 12, 3, 6]).toString()}]`); // => [ 3, 6, 12, 47, 89 ]
console.log(`sortNumbers([80, 9, 350, 42, 27]) = [${sortNumbers([80, 9, 350, 42, 27]).toString()}]`); // => [ 9, 27, 42, 80, 350 ]
console.log(quickSort([2, 13, 7, 43, 27])); // => [ 2, 7, 13, 27, 43 ]
console.log(`[ ${quickSort([1, 30, 4, 21, 100000]).join(", ")} ]\n`); // => [ 1, 4, 21, 30, 100000 ]
// STEP 7
console.log(spamWord(3, "Mae")); // => "Mae Mae Mae"
console.log(spamWord(4, "Gao") + "\n"); // => "Gao Gao Gao Gao"
// STEP 8
console.log(`${toSeconds(3)} seconds`); // => 180 seconds
console.log(`${toSeconds(4.5)} seconds\n`); // => 240 seconds
// STEP 9
console.log(firstAndLast(["duck", "duck", "quail", "goose"])); // => ["duck", "goose"]
console.log(`[ ${firstAndLast([2, 4, 6, 8, 10]).join(", ")} ]\n`); // => [2, 10]
// STEP 10
console.log(`The April birthstone is a ${getBirthstone("April")}.`); // => "Diamond"
console.log(`The September birthstone is a ${getBirthstone("September")}.`); // => "Sapphire"