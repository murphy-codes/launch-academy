public class BankAccount {
  private String accountNumber;
  private double balance;

  public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
    this.balance = 0;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public double getBalance() {
    return this.balance;
  }

  public void deposit(double depositAmount) {
    this.balance += depositAmount;
  }

  public double withdraw(double withdrawalAmount) {
    if (this.balance < withdrawalAmount) { this.balance = 0; }
    else { this.balance -= withdrawalAmount; }
    return withdrawalAmount;
  }
}