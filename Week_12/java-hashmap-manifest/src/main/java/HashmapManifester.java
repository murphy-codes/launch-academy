import java.io.File;
import java.io.IOException;
import java.util.*;

public class HashmapManifester {
  public static void main(String[] args) throws IOException {
    Scanner crewManifestScanner = new Scanner(new File("crewManifest.txt"));
    Map<String, String> crew = new HashMap<>();
    List<String> crewNames = new ArrayList<>();
    while (crewManifestScanner.hasNextLine()) {
      String[] crewMember = crewManifestScanner.nextLine().split(", ");
      crew.put(crewMember[1], crewMember[0]);
      crewNames.add(crewMember[1]);
    }
//    //Will be 'out of order' due to Hashmap
//    crew.forEach((name, rank) -> { System.out.println(name + " (" + rank + ")"); });
    crewNames.forEach(name -> System.out.println(name + " (" + crew.get(name) + ")"));
  }
}
