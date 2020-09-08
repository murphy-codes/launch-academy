import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainMenu {
  private static final String AVAILABLE_BOOKS_PATH = "src\\main\\resources\\available-books.txt";
  private static final String CHECKED_OUT_BOOKS_PATH = "src\\main\\resources\\checked-out-books.txt";
  private static final String NUM_DONATIONS_PATH = "src\\main\\resources\\num-books-donated.txt";

  public static final String ADD_BOOK_TEXT = "Contribute a book";
  public static final String CHECKOUT_TEXT = "Check out a book";
  public static final String RETURN_BOOK_TEXT = "Return a book";
  public static final String QUIT_TEXT = "Quit";

  private int numBooksDonated;
  private int authorizedCheckouts;

  public enum MenuOption {
    a(ADD_BOOK_TEXT),
    c(CHECKOUT_TEXT),
    r(RETURN_BOOK_TEXT),
    q(QUIT_TEXT);

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    public String toString() {
      return this.name() + ". " + this.optionText;
    }
  }

  @Override
  public String toString() {
    String output = "";
    for(MenuOption option : MenuOption.values()) {
      output += option.toString() + "\n";
    }
    return output;
  }

  public MainMenu() throws IOException {
    this.numBooksDonated = getNumBooksDonated();
    this.authorizedCheckouts = getAuthorizedCheckouts();
  }

  public void promptUntilQuit() throws IOException {
    System.out.println("Because you have donated " + getNumBooksDonated() + " books, your max# checkouts is: " + getAuthorizedCheckouts());
    System.out.println(this.toString());

    MenuOption input = null;
    Scanner scanner = new Scanner(System.in);
    do{
      System.out.print("> ");
      try {
        input = MenuOption.valueOf(scanner.next());
      } catch(IllegalArgumentException error) {
        System.out.println("Please make a valid selection!");
      }

      if(input == MenuOption.a) {
        addBook(getStringInputOptional("What is the title of your book? "));
      }
      else if(input == MenuOption.c) {
        checkOutBook();
      }
      else if(input == MenuOption.r) {
        returnBook();
      }
      if(input != MenuOption.q) { System.out.println("Returning to main menu."); }
    } while(input != MenuOption.q);
    System.out.println("Thanks! Come to the library again.");
    scanner.close();
  }

  public int getNumBooksDonated() throws FileNotFoundException {
    File numBooksDonatedFile = new File(NUM_DONATIONS_PATH);
    if (numBooksDonatedFile.exists()) {
      Scanner scanner = new Scanner(numBooksDonatedFile);
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        System.out.println("Error: Number of donations not found.");
      }
    } else {
      System.out.println("Error: File \"" + NUM_DONATIONS_PATH + "\" not found.");
    }
    return 0;
  }

  public void incrementNumBooksDonated() throws IOException {
    File authorizedCheckoutsFile = new File(NUM_DONATIONS_PATH);
    if (authorizedCheckoutsFile.exists()) {
      FileWriter fileWriter = new FileWriter(authorizedCheckoutsFile);
      this.numBooksDonated++;
      if (this.numBooksDonated % 2 == 0) { this.authorizedCheckouts = getAuthorizedCheckouts(); }
      fileWriter.write("" + this.numBooksDonated);
      fileWriter.close();
    } else { System.out.println("Error: File \"" + NUM_DONATIONS_PATH + "\" not found."); }
  }

  public int getAuthorizedCheckouts() {
    return 2 + numBooksDonated/2;
  }

  public ArrayList<String> getBooks(String filePath) throws FileNotFoundException {
    ArrayList<String> books = new ArrayList<String>();
    File booksFile = new File(filePath);
    if (booksFile.exists()) {
      Scanner bookScanner = new Scanner(booksFile);
      while (bookScanner.hasNextLine()) {
        books.add(bookScanner.nextLine());
      }
    } else { System.out.println("Error: File \"" + filePath + "\" not found."); }
    return books;
  }

  public void addBook(String book) throws IOException {
    if (book.isEmpty()) { System.out.print("Cancelling donation. "); }
    else if (getBooks(AVAILABLE_BOOKS_PATH).contains(book)) { System.out.print("That book is already in our library! "); }
    else {
      appendToBook(book, AVAILABLE_BOOKS_PATH);
      incrementNumBooksDonated();
      System.out.print("We've added \"" + book + "\" to our library. You've donated " + this.numBooksDonated + " book" + ((this.numBooksDonated == 1) ? "" : "s") + ". ");
      System.out.print((this.numBooksDonated % 2 == 0) ? "You can now checkout a max of " + this.authorizedCheckouts + " books! " : "");
      System.out.println("Thank you!");
    }
  }

  public void appendToBook(String newBook, String filePath) throws IOException {
    File booksFile = new File(filePath);
    if (booksFile.exists()) {
      FileWriter fileWriter = new FileWriter(booksFile, true);
      fileWriter.write(newBook + "\n");
      fileWriter.close();
    } else { System.out.println("Error: File \"" + filePath + "\" not found."); }
  }

  public void writeToBooks(ArrayList<String> books, String filePath) throws IOException {
    File booksFile = new File(filePath);
    if (booksFile.exists()) {
      FileWriter fileWriter = new FileWriter(booksFile);
      for(int i = 0; i < books.size(); i++) { fileWriter.write(books.get(i) + "\n"); }
      fileWriter.close();
    } else { System.out.println("Error: File \"" + filePath + "\" not found."); }
  }

  public void checkOutBook() throws IOException {
    int numCheckedOut = getBooks(CHECKED_OUT_BOOKS_PATH).size();
    if(numCheckedOut < this.authorizedCheckouts) {
      ArrayList<String> books = getBooks(AVAILABLE_BOOKS_PATH);
      System.out.println("Here are our available books:");
      for(int i = 0; i < books.size(); i++) { System.out.println(i+1 + " - " + books.get(i)); }
      int bookNum = getIntInput("Which book would you like to checkout? (By number): ", books.size())-1;
      if (bookNum == -1) { System.out.print("Cancelling check out. "); }
      else {
        String book = books.get(bookNum);
        books.remove(bookNum);
        writeToBooks(books, AVAILABLE_BOOKS_PATH);
        appendToBook(book, CHECKED_OUT_BOOKS_PATH);
        System.out.println("You've checked out book #" + (bookNum+1) + ": \"" + book + "\".");
        System.out.println("You're at now " + (numCheckedOut+1) + "/" + this.authorizedCheckouts + " of your available book checkout limit.");
      }
    } else { System.out.println("You're at your max checkout limit. Please return a book first!"); }
  }

  public void returnBook() throws IOException {
    int numCheckedOut = getBooks(CHECKED_OUT_BOOKS_PATH).size();
    if(numCheckedOut == 0) { System.out.print("You don't have any books checked out. "); }
    else {
      ArrayList<String> books = getBooks(CHECKED_OUT_BOOKS_PATH);
      System.out.println("Here are the books you've checked out:");
      for(int i = 0; i < books.size(); i++) { System.out.println(i+1 + " - " + books.get(i)); }
      int bookNum = getIntInput("Which book would you like to return? (By number): ", books.size())-1;
      if (bookNum == -1) { System.out.print("Cancelling return. "); }
      else {
        String book = books.get(bookNum);
        books.remove(bookNum);
        writeToBooks(books, CHECKED_OUT_BOOKS_PATH);
        appendToBook(book, AVAILABLE_BOOKS_PATH);
        System.out.println("You've returned book #" + (bookNum+1) + ": \"" + book + "\".");
        System.out.println("You now have " + (this.authorizedCheckouts-numCheckedOut+1) + "/" + this.authorizedCheckouts + " available book rentals.");
      }
    }
  }

  public static String getStringInputOptional(String prompt) {
    System.out.print(prompt);
    Scanner inputScanner = new Scanner(System.in);
    return inputScanner.nextLine();
  }

  public static boolean isInteger(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) { return false; }
  }

  public static boolean inRange(int i, int min, int max) {
    return min <= i && i <= max;
  }

  public static int getIntInput(String prompt, int last) {
    Integer inputInt = null;
    System.out.print(prompt);
    Scanner inputScanner = new Scanner(System.in);

    while (inputInt == null) {
      String inputStr = inputScanner.nextLine();
      if (inputStr.isEmpty()) { inputInt = 0; }
      else if (!isInteger(inputStr)){ System.out.println("Please input a number selection."); }
      else {
        int num = Integer.parseInt(inputStr);
        if (inRange(num, 1, last)) { inputInt = num; }
        else { System.out.println("Please choose a number between 1 - " + last); }
      }
    }

    return inputInt;
  }
}