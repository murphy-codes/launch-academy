import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainMenu {
  public static final String ADD_CONTACT_TEXT = "Add a contact";
  public static final String LOOK_UP_CONTACT_TEXT = "Lookup a contact";
  public static final String GENERATE_DISTRIBUTION_LIST_TEXT = "Generate a distribution list";
  public static final String CLEAR_CONTACTS_TEXT = "Clear all contacts";
  public static final String SAVE_CSV_TEXT = "Save contacts to a CSV file";
  public static final String LOAD_CSV_TEXT = "Load contacts from CSV file";
  public static final String QUIT_TEXT = "Quit";
  private List<Contact> contacts;

  public MainMenu() {
    this.contacts = new ArrayList<>();
    loadFromCSV("initialContacts.csv");
  }

  public enum MenuOption {
    a(ADD_CONTACT_TEXT),
    l(LOOK_UP_CONTACT_TEXT),
    d(GENERATE_DISTRIBUTION_LIST_TEXT),
    c(CLEAR_CONTACTS_TEXT),
    s(SAVE_CSV_TEXT ),
    o(LOAD_CSV_TEXT),
    q(QUIT_TEXT);

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    @Override
    public String toString() { return this.optionText; }
  }

  @Override
  public String toString() {
    String output = "";
    int i = 1;
    for(MenuOption option : MenuOption.values()) { output += "  " + i++ + ". " + option.toString() + "\n"; }
    return output;
  }

  public void promptUntilQuit() {
    Map<String, String> options = new HashMap<>();
    options.put("1", "a");
    options.put("2", "l");
    options.put("3", "d");
    options.put("4", "c");
    options.put("5", "s");
    options.put("6", "o");
    options.put("7", "q");
    printMenu();
    MenuOption input;
    Scanner scanner = new Scanner(System.in);
    do{
      input = null;
      System.out.print("> ");
      try {
        String userInput = scanner.next();
        if (options.containsKey(userInput)) { input = MenuOption.valueOf(options.get(userInput)); }
        else { input = MenuOption.valueOf("0"); }
      } catch(IllegalArgumentException error) { System.out.println("Please make a valid selection!"); }

      if(input == MenuOption.a) { addContact(); }
      else if(input == MenuOption.l) { lookUpContact(); }
      else if(input == MenuOption.d) { System.out.println(generateDistributionList()); }
      else if(input == MenuOption.c) { clearAddressBook(); }
      else if(input == MenuOption.s) { saveToCSV(); }
      else if(input == MenuOption.o) { loadFromCSV(); }
      if(input != MenuOption.q) { printMenu(); }
    } while(input != MenuOption.q);
    System.out.println("Thanks! Please use the address book again soon!");
    scanner.close();
  }

  private void printMenu() { System.out.println("\nMain Menu:\n  "+ this.contacts.size() + " contact(s)\n-------------------------------\n" + this.toString()); }

  private static String getStringInput(String prompt) {
    System.out.print(prompt);
    Scanner inputScanner = new Scanner(System.in);
    String inputStr = inputScanner.nextLine();
    while (inputStr.isEmpty()) {
      System.out.print("Please input something: ");
      inputStr = inputScanner.nextLine();
    }
    return inputStr;
  }

  private static String promptYesNo(String prompt) {
    String inputStr = getStringInput(prompt);
    while (!inputStr.equals("y") && !inputStr.equals("n")) { inputStr = getStringInput("Please input either 'y' or 'n': "); }
    return inputStr;
  }

  private void addContact() {
    String name = getStringInput("What is the name of your new contact? ");
    boolean duplicateValue = false;
    int duplicateValueIndex = 0;
    String proceed = "y";
    for (Contact contact: this.contacts) { if (contact.getName().equals(name)) { duplicateValue = true; }}
    for (int i = 0; i < this.contacts.size() ; i++) {
      if (this.contacts.get(i).getName().equals(name)) {
        duplicateValue = true;
        duplicateValueIndex = i;
      }
    }
    if (duplicateValue) { proceed = promptYesNo("Overwrite this contact? (y/n) "); }
    if (proceed.equals("y")) {
      String email = getStringInput("What is their email? ");
      if (duplicateValue) { this.contacts.set(duplicateValueIndex, new Contact(name, email)); }
      else { this.contacts.add(new Contact(name, email)); }
      System.out.println("Contact " + ((duplicateValue) ? "updat" : "add") + "ed!");
    }
  }

  private void addContact(String name, String email) {
    boolean duplicateValue = false;
    int duplicateValueIndex = 0;
    String proceed = "y";
    for (Contact contact: this.contacts) { if (contact.getName().equals(name)) { duplicateValue = true; }}
    for (int i = 0; i < this.contacts.size() ; i++) {
      if (this.contacts.get(i).getName().equals(name)) {
        duplicateValue = true;
        duplicateValueIndex = i;
      }
    }
    if (duplicateValue) { proceed = promptYesNo("Overwrite this contact? (y/n) "); }
    if (proceed.equals("y")) {
      if (duplicateValue) { this.contacts.set(duplicateValueIndex, new Contact(name, email)); }
      else { this.contacts.add(new Contact(name, email)); }
    }
  }

  private void lookUpContact() {
    String name = getStringInput("What is the name of the contact you'd like to look up? ");
    String[] email = new String[1];
    this.contacts.forEach(contact -> { if (contact.getName().equals(name)) { email[0] = contact.getEmail(); }});
    if (email[0] != null) { System.out.println("  " + email[0]); }
    else { System.out.println("  The contact was not found."); }
  }

  private String generateDistributionList() {
    List<String> distributionList = new ArrayList<>();
    this.contacts.forEach(contact -> distributionList.add("\"" + contact.getName() + "\" <" + contact.getEmail() + ">"));
    return String.join(", ", distributionList);
  }

  private void clearAddressBook(boolean skipConfirmation) { if (skipConfirmation) { this.contacts = new ArrayList<>(); } }

  private void clearAddressBook() {
    String proceed = promptYesNo("Are you sure you want to clear all contacts? (y/n) ");
    if (proceed.equals("y")) { this.contacts = new ArrayList<>(); }
  }

  private void saveToCSV() {
    try {
      String fileName = getStringInput("File name: ");
      while (fileName.length() < 3) { fileName = getStringInput("File name must be longer than 2 characters. Please choose a new name: "); }
      String contactsStr = "";
      for (Contact contact: this.contacts) { contactsStr += contact.getName() + "," + contact.getEmail() + "\n"; }
      File contactsOutFile = new File(fileName + ".csv");
      FileWriter fileWriter = new FileWriter(contactsOutFile);
      fileWriter.write(contactsStr);
      fileWriter.close();
      if (contactsOutFile.exists()) { System.out.println("\nContacts file created.\n"); }
    }
    catch (IOException e) { e.printStackTrace(); }
  }

  private void loadFromCSV(String fileName) {
    try {
      File contactsInFile = new File(fileName);
      if (contactsInFile.exists()) {
        Scanner contactScanner = new Scanner(contactsInFile);
        clearAddressBook(true);
        while (contactScanner.hasNextLine()) {
          String contact[] = contactScanner.nextLine().split(",");
          addContact(contact[0], contact[1]);
        }
      } else { System.out.println("File \"" + fileName + "\" not found!"); }
    }
    catch (IOException e) { e.printStackTrace(); }
  }

  private void loadFromCSV() {
    String fileName = getStringInput("File name: ");
    if (!fileName.contains(".csv")) { fileName += ".csv"; }
    loadFromCSV(fileName);
  }
}
