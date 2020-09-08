import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Spaceship {
  private static final String CREW_FILE = "crewManifest.json";
  private static final String INVENTORY_FILE = "inventory.json";
  private static final String REMOVE_INVENTORY_FILE = "removeinventory.json";
  private static final String CAPTAIN = "Captain";

  public static void main(String[] args) {
    Map<String, String> crewMap = jsonReader(CREW_FILE);
    System.out.println("Crew: \n-----------");
    crewMap.forEach((key, value) -> System.out.println("Rank: " + key + ", Name: " + value) );

    Map<String, Integer> inventoryMap = jsonReader(INVENTORY_FILE);
    Map<String, Integer> removeInventoryMap = jsonReader(REMOVE_INVENTORY_FILE);

    removeInventoryMap.forEach((key, value) -> {
      if (inventoryMap.containsKey(key)) {
        if (inventoryMap.get(key) > value) { inventoryMap.replace(key, inventoryMap.get(key)-value); }
        else { inventoryMap.remove(key); }
      }
    });

    System.out.println("\nINVENTORY: \n-----------");
    inventoryMap.forEach((key, value) -> { System.out.println("Item: " + key + ": " + value); });
  }

  private static Map jsonReader(String filePath) {
    try {
      byte[] mapData = Files.readAllBytes(Paths.get(filePath));
      ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
      return objectMapper.readValue(mapData, HashMap.class);
    } catch (IOException io ) {
      io.printStackTrace();
      return Collections.emptyMap();
    }
  }
}
