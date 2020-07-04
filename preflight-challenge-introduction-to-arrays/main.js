/*

# At the Bank

- Programmatically answer the questions below about 
  the provided array

*/

let bankLine = ["Sam", "Amy", "John", "Sally", "Susan"]

//Who is first in line?
console.log(bankLine[0]);

//Who's third in line?
console.log(bankLine[2]);

//Who's last in line?
console.log(bankLine[bankLine.length-1]);

//What index is Sally at?
console.log(`Susan is at index: ${bankLine.indexOf("Sally")} (she is #${bankLine.indexOf("Sally")+1} in line)`);

//Bill has entered the bank. Add him to the end of the line
bankLine.push("Bill");

//What is the new length of the line?
console.log(`The new length of the line is ${bankLine.length}.`);