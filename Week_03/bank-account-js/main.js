import BankAccount from './BankAccount.js'

let initialBalance = 1000
let bills = [-45, -99.95, -34.43]

// create a new BankAccount
let launchFund = new BankAccount(initialBalance);

// print out current balance
bills.forEach(transaction => { launchFund.addTransaction(transaction); });

console.log(`Our Launch Fund began with ${launchFund.showStartingBalance()}, \n  but after ${launchFund.getTransactionCount()} transactions, \n  our current balance is: ${launchFund.showBalance()}.`);