function validateYesNo(input) {
    if(input === "yes" || input === "y" || input === "n" || input === "no") {
        return true;
    } else {
        return false;
    }
}

// As you satisfy the acceptance criteria, log your work to the browser console. Don't be afraid to use your Google skillz and look at prior articles to figure out how to assess input!

// As a user, I should be greeted by the program at the door.their party.
console.log('* The burly, old doorman greets your group. *');
alert('Greetings traveler. Stay awhile and listen!');

// The program prompts a user to enter the number of members in their party.
console.log('* The doorman asks for a count of your group. *');
let partySize = parseInt(prompt('How many people are in your party, young adventurer?'));

// If the user enters invalid input (anything not a number) re-prompt them.
while (isNaN(partySize)) {
    console.log('bruhh - partySize');
    partySize = parseInt(prompt("I didn't quite catch that. Could you tell me again how many of you wish to enter our tavern?"));
}

// If the party is equal to or less than 8, the program moves on. If not, the program alerts the user it's too busy to let them in, and the program ends.
let admittance = false;
if (partySize <= 8) {
    admittance = true;
} else {
    console.log("I'm afraid there isn't room for your posse at the moment. Perhaps you'll find better fortune upon a later visit?");
}

// If the party is equal to or less than 8, the program asks if all members are equal to or over 21 years of age. If yes, the program moves on. If no, the program alerts the party that all members must be over 21 and the program ends.
// If the user enters invalid input (anything not a number) re-prompt them.
let youngestMemberAge;
let ofAge;
if (admittance) {
    console.log('* The doorman now needs to confirm that everyone is of drinking age. *');
    while (isNaN(partySize)) {
        console.log('bruhh - partySize');
        partySize = parseInt(prompt("I didn't quite catch that. Could you tell me again how many of you wish to enter our tavern?"));
    }
    youngestMemberAge = prompt("And be the youngest of ye able to partake?.. How many years are they?").toLowerCase();
    while (isNaN(youngestMemberAge)) {
        console.log('bruhh - youngestMemberAge - #');
        youngestMemberAge = prompt("Forgive me in my age; I must have misheard you. Come again?\n\nCan they have spirits? What age is your youngest?").toLowerCase();
    }
    if (youngestMemberAge >= 21) {
        ofAge = true;
        console.log(`ofAge set to ${ofAge}`);
    } else {
        console.log("I'm sorry, but I can't rightly let youngsters such as ye into our tavern. Perhaps when you're older.");
    }
}

//If all members are over 21, the program prompts the user to confirm all members have a valid ID with them. If all do, the program moves on. If they do not, the program alerts the party that all members must have a valid ID, and the program ends.
// If the user enters invalid input (anything not 'yes' or 'no') re-prompt them.
let partyDocs;
let gotDocs;
if (ofAge){
    console.log('* The doorman now requests identification from everyone. *');
    partyDocs = prompt("And can ye all prove this with ye documents, 'case the lawmen come around?").toLowerCase();
    while(!validateYesNo(partyDocs)) {
        console.log('bruhh - partyDocs - yes/no');
        partyDocs = prompt("Pardon me friend, but I must have misheard thou. Dost ye all have docs?").toLowerCase();
    }
    if (partyDocs === "n" || partyDocs === "no") {
        console.log("Forgive me, but without ye documents I can't let ye pass.");
    } else {
        gotDocs = true;
    }
}

// If all members have a valid ID, the program confirms no one is wearing jeans, and welcomes them in. If someone is wearing jeans, the program alerts them there's a dress code, and the program ends.
// If the user enters invalid input (anything not 'yes' or 'no') re-prompt them.
let noJeans;
if (gotDocs) {
    console.log('* Lastly, the doorman checks to make sure everyone meets the dress-code: no jeans allowed. *');
    noJeans = prompt("None of ye be weaing those cursed denim pants, right?").toLowerCase();
    while(!validateYesNo(noJeans)) {
        console.log('bruhh - noJeans - yes/no');
        noJeans = prompt("My eyes and ears aren't what they used to be. Are any of ye wearing denim bottoms?").toLowerCase();
    }
    if (noJeans === "n" || noJeans === "no") {
        console.log("Forgive me, but I can't let ye in. The barkeep would have my head if I let any of ye in dressed like that!");
    } else {
        console.log("Welcome! Enjoy your drinks friends!");
    }
}