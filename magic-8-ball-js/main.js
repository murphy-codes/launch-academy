/* 
Launch Academy
Assignment: Magic 8 Ball JavaScript
Author: Tom Murphy
Last Edited: 2020-06-21 21:57 PT
*/

let responses = [
  "It is certain",
  "It is decidedly so",
  "Without a doubt",
  "Yes, definitely",
  "You may rely on it",
  "As I see it, yes",
  "Most likely",
  "Outlook good",
  "Yes",
  "Signs point to yes",
  "Reply hazy try again",
  "Ask again later",
  "Better not tell you now",
  "Cannot predict now",
  "Concentrate and ask again",
  "Don't count on it",
  "My reply is no",
  "My sources say no",
  "Outlook not so good",
  "Very doubtful"
]

let randomIndex = (length) => {
  return Math.floor((Math.random() * length));
}

// Confirm the correct number of responses have been stored by printing the number to the console (`20`)
console.log(responses.length + ' total responses.');
// Ask the user what their question is, and store it as a variable called `question`
//const question = prompt('What is your question?');
// Output a random response to the user's question
console.log(responses[randomIndex(responses.length)]);
// Output the number of responses that include the word "yes"
const yeses = responses.filter(str => str.toLowerCase().includes('yes'));
console.log(yeses.length + ' responses contain the word \'yes\'.');
// Output the number of responses that include the words "no" or "not"
const noNot = responses.filter(str => str.toLowerCase().includes('no'));
console.log(noNot.length + ' responses contain the characters \'no\'.');
// Output the alphabetized list of responses
console.log(responses.sort());
// Output the first and last responses from the alphabetized list
console.log('First response: ' + responses[0]);
console.log('Last response: ' + responses[responses.length-1]);
// Delete two of the negative responses
responses.splice(responses.findIndex(str => str.toLowerCase().includes('no')), 1);
responses.splice(responses.findIndex(str => str.toLowerCase().includes('no')), 1);
// Reassign 'Ask again later' to the beginning of the array
responses.splice(responses.indexOf('Ask again later'), 1);
responses.unshift('Ask again later');
// Add 1 response of your choosing to the current list
responses.push('Perhaps I shouldn\'t tell you now');
// Concat an **array** of 3 additional responses to the current list
responses = responses.concat(['No', 'There is no spoon', 'Maybe so']);
// Confirm the correct number of responses have been removed and added by printing the number of responses to the console (`22`)
console.log(responses.length + ' total responses.');
