import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ErrandManager {


  public static void main(String[] args) throws IOException {
    // SATURDAY MORNING - STEP 1: //-----------------------------------------------------------------------------------
    Scanner toDoScanner = new Scanner(new File(ErrandManager.class.getResource("todo.txt").getFile()));
    List<String> toDoList = new ArrayList<>();
    while (toDoScanner.hasNextLine()) { toDoList.add(toDoScanner.nextLine()); }
    // SATURDAY MORNING - STEP 2: //-----------------------------------------------------------------------------------
    toDoList.add(toDoList.indexOf("buy groceries"), "go to ATM");
    // SATURDAY MORNING - STEP 3: //-----------------------------------------------------------------------------------
    Map<String, String> toDoMap = new HashMap<>();
    for (String task : toDoList) { toDoMap.put(task, "pending"); }
    // SATURDAY MORNING - STEP 4: //-----------------------------------------------------------------------------------
    toDoMap.put("trim hedges", "complete");
    // SATURDAY MORNING - STEP 5: //-----------------------------------------------------------------------------------
    File groceriesFile = new File(ErrandManager.class.getResource("groceries.json").getFile());
    Map<String, Integer> groceriesMap;
    ObjectMapper objectMapper = new ObjectMapper();
    groceriesMap = objectMapper.readValue(groceriesFile, HashMap.class);
    // SATURDAY MORNING - STEP 6: //-----------------------------------------------------------------------------------
    groceriesMap.put("Loaf of Bread", 1);
    groceriesMap.put("Gallon of Milk", 1);
    // SATURDAY MORNING - STEP 7: //-----------------------------------------------------------------------------------
    File groceriesPricesFile = new File(ErrandManager.class.getResource("grocery_prices.json").getFile());
    Map<String, Integer> groceriesPricesMap;
    groceriesPricesMap = objectMapper.readValue(groceriesPricesFile, HashMap.class);
    // SATURDAY MORNING - STEP 8: //-----------------------------------------------------------------------------------
    Double subtotal = 0.0;
    List<String> unpricedItems = new ArrayList<>();
    for(Map.Entry<String, Integer> grocery: groceriesMap.entrySet()) {
      if(groceriesPricesMap.containsKey(grocery.getKey())) { subtotal += grocery.getValue() * groceriesPricesMap.get(grocery.getKey()); }
      else { unpricedItems.add(grocery.getKey()); }
    }
    System.out.println("Subtotal for groceries $" + subtotal/100);
    if(!unpricedItems.isEmpty()) { System.out.println("Bring extra money for the following items: " + String.join(", ", unpricedItems)); }
    // SATURDAY MORNING - STEP 9: //-----------------------------------------------------------------------------------
    toDoMap.remove("go to ATM");
    toDoMap.put("go to ATM and withdraw $" + subtotal/100, "pending");

    // TIME PERMITTING - STEP 1: //------------------------------------------------------------------------------------
    Map<String, Double> streetsMap;
    streetsMap = objectMapper.readValue(new File(ErrandManager.class.getResource("streets.json").getFile()), HashMap.class);
    // TIME PERMITTING - STEP 2: //------------------------------------------------------------------------------------
    List<String> routeOne = new ArrayList<>(Arrays.asList("Forest St", "South St", "Forest St", "Vernon St", "South St"));
    // TIME PERMITTING - STEP 3: //------------------------------------------------------------------------------------
    List<String> routeTwo = new ArrayList<>(Arrays.asList("South St", "Forest St", "Sally Way", "Sally Way", "South St"));
    // TIME PERMITTING - STEP 4: //------------------------------------------------------------------------------------
      // Write a method… see: calcDistance() ↓
    // TIME PERMITTING - STEP 5: //------------------------------------------------------------------------------------
    System.out.println("Distance of route 1: " + calcDistance(routeOne, streetsMap) + "\nDistance of route 2: " + calcDistance(routeTwo, streetsMap));
  }

  private static double calcDistance(List<String> streets, Map<String, Double> distances) {
    double totalDistance = 0;
    for (String street: streets) { totalDistance += distances.get(street); }
    return totalDistance;
  }
}
