class BankAccount {
  constructor(initialBalance, transactions = []) {
    this.initialBalance = initialBalance;
    this.transactions = transactions;
    this.current = {
      balance: initialBalance,
      transactionCount: 0
    };
    this.resetBalance();
  }

  resetBalance() {
    this.current.transactionCount = 0;
    for (this.current.transactionCount; this.current.transactionCount<this.transactions.length; this.current.transactionCount++) {
      this.current.balance += this.transactions[this.current.transactionCount];
    };
  };

  checkBalance() {
    let result = this.initialBalance;
    this.transactions.forEach(transaction => {
      result += transaction;
    });
    if (result === this.current.balance) { return true; }
    return false;
  };

  getStartingBalance() {
    return this.initialBalance;
  };

  showStartingBalance() {
    return "$" + this.initialBalance.toFixed(2);
  };

  printStartingBalance() {
    console.log(this.showStartingBalance());
  };

  getTransactions() {
    return this.transactions;
  };

  getTransactionCount() {
    return this.current.transactionCount;
  };

  getBalance() {
    return this.current.balance;
  };

  showBalance() {
    return "$" + this.current.balance.toFixed(2);
  };

  printBalance() {
    console.log(this.showBalance());
  };

  addTransaction(amount) {
    if (!isNaN(amount)) { 
      this.transactions.push(parseFloat(amount));
      this.current.balance += parseFloat(amount);
      this.current.transactionCount++;
    }
  };
}

export default BankAccount;