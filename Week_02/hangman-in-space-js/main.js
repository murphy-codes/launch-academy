/* 
Launch Academy
Assignment: Hangman In Space JS
Author: Tom Murphy
Last Edited: 2020-06-23 14:05 PT
*/

//via: https://stackoverflow.com/questions/1431094/how-do-i-replace-a-character-at-a-particular-index-in-javascript/1431113#1431113
String.prototype.replaceAt = function(index, replacement) {
  return this.substr(0, index) + replacement + this.substr(index + replacement.length);
}

function printPuzzle(word, guesses) {
  let puzzle = [];
  for (i = 0; i < word.length; i++) { puzzle.push("_"); }
  if (guesses) {
    for (i = 0; i < guesses.length; i++) { 
      if (word.includes(guesses[i].toLowerCase())) {
        let index = word.indexOf(guesses[i].toLowerCase());
        puzzle[index] = guesses[i].toLowerCase();
        word = word.replaceAt(index, "_");
        if (word.includes(guesses[i].toLowerCase())){i++;}
      }
    }
  }
  return puzzle.join(" ");
}

console.log(printPuzzle("perimeter"));
console.log(printPuzzle("triangle", ["T","s","g"]));