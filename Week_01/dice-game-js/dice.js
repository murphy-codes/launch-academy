// A common need from your team is games to help pass the time. The lack of gravity means their dice always float off mid-game. Build them a JavaScript program that simulates rolling a pair (2) of dice.

// Simple Dice Roller
function simpleDiceRoller() {
    let die1 = Math.floor(Math.random() * 6) + 1;
    let die2 = Math.floor(Math.random() * 6) + 1;
    console.log(`You rolled a ${die1} and a ${die2}`);
    console.log(`Total: ${die1+die2}`);
    console.log(`Press 'Enter' to roll again, 'S' to stop.`);
}

simpleDiceRoller();

// could probably use break & continue instead
let keepRolling = true;
let rollAgain = true;

document.onkeypress = function (e) {
    e = e || window.event;
    if (e.code === "KeyS" && keepRolling === true){
        //User pressed the 'S' key. Stop the simple game.
        console.log("Stopped.\n\nStarting the Advanced Dice Roller game.");
        keepRolling = false;
        advancedDiceRoller();
    } else if (e.code === "Enter" && keepRolling === true){
        //User pressed the 'Enter' key. Replay the simple game.
        console.log("\n");
        simpleDiceRoller();
    } else if (e.code === "KeyN" && rollAgain === true){
        //User pressed the 'N' key. Stop the advanced game
        console.log("Ending Advanced Dice Roller game.");
        rollAgain = false;
    } else if (e.code === "KeyY" && rollAgain === true){
        //User pressed the 'Y' key. Replay the advanced game.
        console.log("\n");
        advancedDiceRoller();
    }
};

// Attempt to vet user inputted
function validateNumInput(input) {
    if (input === NaN) {
        return false;
    } else if (input < 1){
        return false;
    } else {
        return true;
    }
}

// Advanced Dice Roller
function advancedDiceRoller() {
    let dieSides;
    let numRolls;
    do {
        dieSides = parseInt(prompt("How many sides does your dice have?"));
    } while (!validateNumInput(dieSides))
    do {
        numRolls = parseInt(prompt("How many times would you like to roll your pair of dice?"));
    } while (!validateNumInput(dieSides))
    let die1;
    let die2;
    for (i = 0; i < numRolls; i++) {
        // Thanks to Jeremy for this version of random that uses Math.ceil
        die1 = Math.ceil(Math.random() * dieSides);
        die2 = Math.floor(Math.random() * dieSides) + 1;
        console.log(`You rolled a ${die1} and a ${die2}. Total: ${die1+die2}`);
    }
    console.log("\nRoll Again? (y/n)");
}

