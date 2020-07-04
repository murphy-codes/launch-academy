/* 
Launch Academy
Assignment: Address Book
Author: Tom Murphy
Last Edited: 2020-06-24 01:38 PT
*/

let addressBook = {
  "Mark Zuckerberg": "markymark@example.com",
  "Grace Hopper": "foundABug@example.com",
  "Alan Turing": "alanTheMachine@example.com",
  "Sister Mary Kenneth Keller": "theOGDoctor@example.com",
  "Ada Lovelace": "kindaCalledThisWholeComputerThing@example.com",
  "Bill Gates": "noBlueScreens@example.com"
}

let toPascalCase = (str) => {
  if (str === null) {return null;}
  let words = str.split(" ");
  for (i=0; i<words.length; i++) {
    if (words[i].length > 1) {
      words[i] = words[i][0].toUpperCase() + words[i].slice(1).toLowerCase();
    } else {
      words[i] = words[i].toUpperCase();
    }
  }
  return words.join(" ");
}

let partialNameCheck = (shortName, namesList = Object.keys(addressBook)) => {
  for (i=0; i<namesList.length; i++) {
    if (namesList[i].toLowerCase().includes(shortName.toLowerCase())) {return namesList[i];}
  }
  return false;
}

let name;
do {
  name = toPascalCase(prompt("Whose email address would you like?"));
  if (name === null || name === "Exit") {
    // Base case: do nothing - don't alert the user - exit while loop
  } else if (partialNameCheck(name)) {
    console.log(`${partialNameCheck(name)}'s email: ${addressBook[partialNameCheck(name)]}`);
  } else {
    if (confirm("Sorry, but that name was not found.\n\n" + 
                "Would you like to add that name to the address book?")) {
      addressBook[name] = prompt("What is their email address?");
    }
  }
} while (!(name === null || name === "Exit"))