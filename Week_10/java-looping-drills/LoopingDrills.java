import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoopingDrills {
  public static void main(String[] args) throws IOException {
    //  Count down from 1000 to 711, printing each number on its own line. Skip numbers divisible by 15.
    for (int i = 1000; i > 710; i--) { if (i % 15 != 0) {System.out.println(i);} }

    //  Ask the user for two numbers
    System.out.println("\nInput two INTEGERS, with the 2nd value being larger than the 1st, \n  so we may sum the total of the whole numbers between them (inclusively).");
    //  Assume the user will always enter integers
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("\nEnter a lower number: ");
    int lowerBound = inputScanner.nextInt();
    System.out.print("Enter an upper number: ");
    int upperBound = inputScanner.nextInt();
    //  Validate that the second number is larger than the first. If the user enters invalid numbers, exit the program
    if (lowerBound >= upperBound) {
      System.out.println("ERROR: The second value was not smaller than the first.\n\nSHUTTING DOWN.");
      System.exit(0);
    }
    //  Calculate the sum of the numbers that are in between the two provided numbers, without including the numbers inputted. IE, if the user enters 2 and 6, the resulting sum would be 12 (3 + 4 + 5)
    int sum = 0, loopCounter = 0;
    for (int i = lowerBound; i <= upperBound; i++) {
      sum+=i;
      loopCounter++;
    }
    System.out.println("The sum of the numbers from " + lowerBound + " to " + upperBound + " is: " + sum + "    [Determined in " + loopCounter + " iterations]");
    System.out.println("Alternatively, we can calculate this in O(1) time by using Gauss's summation formula <n(n+1)/2>. In which case, the answer is still " + ((upperBound*(upperBound+1)/2)-(lowerBound*(lowerBound-1)/2)));

    //  Ask the user for a number
    System.out.print("\nInput a number to be multiplied: ");
    int toBeMultiplied = inputScanner.nextInt();
    //  Print the products of that number with every number from 1 - 12
    for (int i = 1; i < 13; i++) { System.out.print(i*toBeMultiplied + " "); }
    System.out.println();

    //  Ask the user for a number
    //  Output whether it is odd or even
    //  Ask the user to enter another number to check
    //  Continue this until the user types "exit"
    //  Be sure to handle for bad input (when Java integer parsing fails) - allow the user to attempt to re-enter a number
    String exitStr = "";
    do {
      int oddOrEven = 0;
      boolean continueLoop = true;

      if (exitStr.matches("-?\\d+")) { oddOrEven = Integer.parseInt(exitStr); }
      else {
        System.out.print("\nInput a whole number, so we may determine its evenness: ");
        do {
          try {
            oddOrEven = inputScanner.nextInt();
            continueLoop = false;
          } catch (InputMismatchException e) {
            inputScanner.nextLine();
            System.out.print("Invalid input. Please enter a whole number: ");
          }
        } while (continueLoop);
      }

      if (oddOrEven % 2 == 0) { System.out.printf("%d is even\n", oddOrEven); }
      else { System.out.printf("%d is odd\n", oddOrEven); }

      exitStr = promptExit("\nInput another number to check, or input 'exit' to stop.");
    } while (!exitStr.equals("exit"));


    //  A number is prime if it is not the product of two smaller natural numbers. IE, 7 is prime because it is only evenly divisible by 7 (itself) and 1.
    //  Write a program that uses a loop to determine if a user supplied number is prime or not.
    System.out.println("7 is " + ((isPrime(7)) ? "" : "not") + " prime.");
    System.out.println("27 is " + ((isPrime(27)) ? "" : "not") + " prime.");
    System.out.println("29 is " + ((isPrime(29)) ? "" : "not") + " prime.");
    System.out.println("42 is " + ((isPrime(42)) ? "" : "not") + " prime.");
    System.out.println("151 is " + ((isPrime(151)) ? "" : "not") + " prime.");

    //  Non-Core Drills ------------------------------------------------------------
    //  Use the code from "Multiplication Table Prompt"
    //  Automatically generate the multiplication table for every number from 1 to 12 without prompting the user for any data
    //  Extract a method that takes a single argument, and returns a string representing the multiplication table
    String mTable = multiplicationTable("Let's practice multiplication!");
    System.out.println(mTable);

    //  Write a program that asks the user to add numbers until they specify "done"
    //  With each number entered, add it to a running total of all numbers entered
    //  Be sure to handle for the user specifying an invalid number. The user should be given an opportunity to re-enter a number to continue on with the calculation
    System.out.println("Let's add together a series of numbers.");
    System.out.print("Input a whole number, or enter 'done' to exit: ");
    boolean continueLoop = true;
    int runningSum = 0;
    while (continueLoop) {
      if (inputScanner.hasNextInt()) {
        runningSum += inputScanner.nextInt();
        System.out.print("Input another whole number, or enter 'done' to find the sum: ");
      } else {
        String userInput = inputScanner.next();
        if (userInput.equals("done")) { continueLoop = false; }
        else { System.out.print("Please enter a whole number: "); }
      }
    }
    System.out.println("\nThe sum of those numbers is: " + runningSum);
  }

  public static String promptExit(String prompt) throws IOException {
    System.out.println(prompt);
    Scanner inputScanner = new Scanner(System.in);
    String exitStr = inputScanner.nextLine().toLowerCase();
    return exitStr;
  }

  public static boolean isPrime(int optimusPrime) {
    boolean flag = false;

    for(int i = 2; i <= optimusPrime/2; i++) {
      if (optimusPrime % i == 0) {
        flag = true;
        break;
      }
    }

    if (!flag)
      return true;
    else
      return false;
  }

  public static String multiplicationTable(String prompt) {
    String table = prompt + "\n";
    for(int i = 1; i <= 12; i++) {
      for(int j = 1; j <= 12; j++) {
        table += String.format("%1$3s", (i * j)) + " ";
      }
      table += "\n";
    }
    return table;
  }
}