// https://github.com/airbnb/javascript#blocks
// 16.3 If an if block always executes a return statement, the subsequent else block is unnecessary.
function validateCurrency(amount) {
  // I use 0.005 instead of 0 to prevent small values from being rounded down to 0
  if(isNaN(amount) || amount <= 0.005) {
    return false;
  }
  return true;
}

function toCurrency(amount) {
  // Accepts a (pre-validated) float.
  // Returns a 2-digit float.
  return parseFloat(amount.toFixed(2));
}
  
// --- Part 1 - Allow a User to "Open" an Account
//   As a banker, I want to be able to open a new account.
//   Prompt, then console.log
let startingBalance = parseFloat(prompt(`Welcome to our banking app! Please enter your starting balance.`));
// console.log(`Great! Your account has been opened. Your bank account has a balance of ${startingBalance}.`);

// --- Part 2 - Validate the Starting Balance
//   Update your initial code to add conditional logic to validate the user input. 
//   Ensure that they have entered a positive number. 
//   If the user entered a negative number, or something that is not a number, 
//   prompt them again for a valid number.
while(!validateCurrency(startingBalance)) {
  startingBalance = parseFloat(prompt(`Sorry! Please enter a positive value of $0.01 or more for your starting balance.`));
}
// Round startingBalance to 2-digits & set back to a float value so we can use it as currency
startingBalance = toCurrency(startingBalance);
console.log(`Thank you for opening an account. Your starting balance is \$${startingBalance}.`);

// --- Part 3 - Allow a User to Deposit Money
//   After the initial balance is displayed, display a confirmation box asking the user 
//   if they would like to make a deposit. If they say "Cancel", move on without action. 
//   If they say "OK", prompt them to input the amount of a deposit they would like to make. 
//   Validate that this input is a positive number, and calculate the new account balance. 
//   Add a console.log with the following message:
let makeDeposit = confirm(`Would you like to make a deposit?`);
let newBalance;
if (makeDeposit) {
  let depositAmount = parseFloat(prompt(`How much would you like to deposit?`));
  while(!validateCurrency(depositAmount)) {
    depositAmount = parseFloat(prompt(`Sorry! Please enter a positive value of $0.01 or more for your deposit amount.`));
  }
  depositAmount = toCurrency(depositAmount);
  newBalance = startingBalance + depositAmount;
  console.log(`Thank you for your deposit of \$${depositAmount}. Your new account balance is \$${newBalance}.`);
} else {
  newBalance = startingBalance;
}

// --- Part 4 - Allow a User to Withdraw Money
//   Once the user has determined if they will deposit funds or not, 
//   display a confirmation box asking the user if they would like to take a withdrawal. 
//   If they say "Cancel", console.log a message
let makeWithdrawal = confirm(`Would you like to make a withdrawal?`);
let finalBalance;
if (makeWithdrawal) {
  let withdrawalAmount = parseFloat(prompt(`How much would you like to withdraw?`));
  while(!validateCurrency(withdrawalAmount) || withdrawalAmount > newBalance) {
    if (withdrawalAmount > newBalance) {
      withdrawalAmount = parseFloat(prompt(`Sorry, but that exceeds your current balance of \$${newBalance}.\n\nHow much would you like to withdraw?`));
    } else {
        withdrawalAmount = parseFloat(prompt(`Sorry! Please enter a positive value of $0.01 or more for your withdrawal amount.`));
    }
  }
  withdrawalAmount = toCurrency(withdrawalAmount);
  finalBalance = newBalance - withdrawalAmount;
  console.log(`You have withdrawn \$${withdrawalAmount}. Your final balance is \$${finalBalance}.`);
} else {
  console.log(`Your final balance is \$${finalBalance}.`);
}
alert(`Thank you for visiting JavaBanksy!`);