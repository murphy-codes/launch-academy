import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class CashRegister {
  private static final String OUTSTANDING_RECEIPTS_PATH = "./outstandingReceipts.txt";
  private static final String RECEIPTS_PATH = "./receipts.txt";

  public static void main(String[] args) throws IOException {
    double registerStartingBalance = getMoneyValue("How much cash did your register have at the beginning of your shift?");
    double registerBalance = registerStartingBalance;
    int transactionCount = 0;

    // Handle the 6 morning regulars that are lined up at the door
    File outstandingReceipts = new File(OUTSTANDING_RECEIPTS_PATH);
    Scanner dataScanner = new Scanner(outstandingReceipts);
    while (dataScanner.hasNextLine()) {
      registerBalance += dataScanner.nextDouble();
      transactionCount++;
    }
    dataScanner.close();
    System.out.println("After a few transactions, our updated balance is $" + String.format("%.2f", registerBalance));

    String repeat = null;
    do {
      registerBalance = processTransaction(registerBalance, transactionCount+1);
      transactionCount++;
      repeat = anotherOne();
    } while (!repeat.equals("exit"));

    System.out.println("\nClosing register.\n");
    System.out.println("Your starting balance was: $" + String.format("%.2f", registerStartingBalance));
    System.out.println("Your ending balance was: $" + String.format("%.2f", registerBalance));
    System.out.println("You processed " + transactionCount + " transactions.");
  }

  public static double getMoneyValue(String prompt) {
    System.out.println(prompt);
    Scanner inputScanner = new Scanner(System.in);
    String moneyValueStr = inputScanner.nextLine();
    while (moneyValueStr.isEmpty()) {
      System.out.println("Please enter a value:");
      moneyValueStr = inputScanner.nextLine();
    }
    double moneyValue = Double.parseDouble(moneyValueStr);
    return moneyValue;
  }

  public static double getMoneyTendered(double currentOrderBalance) {
    double tenderedAmount = 0;
    while (tenderedAmount < currentOrderBalance) {
      tenderedAmount = getMoneyValue("How much cash did the customer provide? Make sure it's more than the order balance.");
    }
    return tenderedAmount;
  }

  public static double[] getChangeDue(double currentOrderBalance, double currentRegisterBalance) {
    double currentPaymentProvided = 0;
    double changeToReturn = currentPaymentProvided - currentOrderBalance;
    while (changeToReturn > currentRegisterBalance || currentPaymentProvided < currentOrderBalance) {
      if (changeToReturn > currentRegisterBalance) {
        currentPaymentProvided = getMoneyValue("Inform the customer that you don't have that much change available. Ask them to please provide cash closer to their total.");
      } else {
        currentPaymentProvided = getMoneyTendered(currentOrderBalance);
      }
      changeToReturn = currentPaymentProvided - currentOrderBalance;
    }
    return new double[] {changeToReturn, currentPaymentProvided};
  }

  public static double processTransaction(double currentRegisterBalance, int transactionNumber) throws IOException {
    double orderBalance = getMoneyValue("How much is the customer's order?");

    double[] transactionAmounts = getChangeDue(orderBalance, currentRegisterBalance);
    double changeDue = transactionAmounts[0];
    double cashProvided = transactionAmounts[1];

    if (changeDue > 0) {
      System.out.println("They are due $" + String.format("%.2f", changeDue) + " in change.");
    } else {
      System.out.println("The customer paid exact change.");
    }

    logReceipt(orderBalance, cashProvided, changeDue, transactionNumber);
    return currentRegisterBalance + orderBalance;
  }

  public static String anotherOne() throws IOException { // DJ Khaled would be proud
    System.out.println("\nInput 'exit' to stop. Otherwise, enter any key to process another transaction.");
    Scanner inputScanner = new Scanner(System.in);
    String exitStr = inputScanner.nextLine().toLowerCase();
    return exitStr;
  }

  public static void logReceipt(double amountDue, double cashProvided, double changeProvided, int transactionNumber) throws IOException {
    String wrapper = "\n--------------------\n";
    File receiptsLog = new File(RECEIPTS_PATH);
    String receipt = "\n" + "TOTAL DUE:  $" + String.format("%.2f", amountDue) + "\nTOTAL PAID: $" + String.format("%.2f", cashProvided) +
                    "\nCHANGE DUE: $" + String.format("%.2f", changeProvided) + wrapper;
    LocalDateTime currentTime = LocalDateTime.now();ber) + "\n  Date: " + currentTime.toLocalDate() +
        "\n  Time: " + String.format("%02d", currentTime.getHour()) + ":
    String timestamp = wrapper + "Transaction #" + String.format("%08d", transactionNum" + String.format("%02d", currentTime.getMinute()) + ":" + String.format("%02d", currentTime.getSecond());

    if (receiptsLog.exists()) {
      FileWriter fileWriter = new FileWriter(receiptsLog, true);
      fileWriter.write("\n" + timestamp + receipt);
      fileWriter.close();
      if (receiptsLog.exists()) { System.out.println("'Receipts.txt' file updated."); }
    } else {
      FileWriter fileWriter = new FileWriter(receiptsLog);
      fileWriter.write("---- RECEIPTS LOG ------------------------\n" + timestamp + receipt);
      fileWriter.close();
      if (receiptsLog.exists()) { System.out.println("'Receipts.txt' file created."); }
    }
  }
}