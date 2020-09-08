import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IFireBotQueueManager {
  public static void main(String[] args) throws FileNotFoundException {
    // PART 1 ----------------------------------------------------------------------------------------------------
    LinkedList<String> doubleALine = new LinkedList<>();
    Scanner initialLineScanner = new Scanner(new File("initial-line.txt"));
    while (initialLineScanner.hasNextLine()) { doubleALine.add(initialLineScanner.nextLine()); }
    // PART 2 ----------------------------------------------------------------------------------------------------
    for (String person: new String[]{"Jim", "Joan", "Lisa", "Marc"}) { doubleALine.add(person); }
    // PART 3 ----------------------------------------------------------------------------------------------------
    if (doubleALine.contains("Jim")) { doubleALine.add(doubleALine.indexOf("Jim"), "Fran"); }
    // PART 4 ----------------------------------------------------------------------------------------------------
    if (doubleALine.contains("Jim") && doubleALine.contains("Fran")) {
      doubleALine.remove("Fran");
      doubleALine.remove(doubleALine.indexOf("Jim"));
    }
    // PART 5 ----------------------------------------------------------------------------------------------------
    List<String> firstFive = new ArrayList<>();
    for (int i = 0; i < 5 ; i++) { if (doubleALine.peek() != null) { firstFive.add(doubleALine.poll()); } }
    System.out.println("Congrats to our first customers: " + String.join(", ", firstFive));
    // PART 6 ----------------------------------------------------------------------------------------------------
    for (int i = 0; i < 3; i++) { System.out.println(doubleALine.removeLast() + " has left the line."); }
    // PART 7 ----------------------------------------------------------------------------------------------------
    System.out.println("There are currently " + doubleALine.size() + " people in the line.");
    // PART 8 ----------------------------------------------------------------------------------------------------
    doubleALine.remove("Alex");
    // PART 9 ----------------------------------------------------------------------------------------------------
    System.out.println(doubleALine.pop() + " has been given an iFireBot!\n*Audience cheers*");
  }
}
