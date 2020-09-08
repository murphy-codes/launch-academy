import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GitHubJobsRunner {
  private static final String GITHUB_FILE = "positions.json";

  public static void main(String[] args) {
    List<Map<String, String>> gitHubPositions = jsonReader(GITHUB_FILE);

    Map<String, Integer> locationCounts = countByField(gitHubPositions, "location");
    List<Map.Entry<String, Integer>> locationCountsList = new LinkedList<>(locationCounts.entrySet());

    Collections.sort(locationCountsList, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
    System.out.println("By location: \n----------------------");
    for (Map.Entry<String, Integer> entry: locationCountsList) {
      String location = entry.getKey().replace("\n", "").replace("  ", " ");
      System.out.println(location + ": " + entry.getValue());
    }

    Map<String, Integer> companyCounts = countByField(gitHubPositions, "company");
    System.out.println("\nBy company: \n----------------------");
    for (Map.Entry<String, Integer> entry: companyCounts.entrySet()) {
      String location = entry.getKey().replace("\n", "").replace("  ", " ");
      System.out.println(location + ": " + entry.getValue());
    }

    System.out.println("\nNew position: \n----------------------");
    String submitJob = getStringInput("Would you like to submit a new job? \n  Input 'y' to submit a new position: ");
    if (submitJob.equals("y")) {
      System.out.println("User inputted: '" + submitJob + "'");
      newJob();
    } else {
      System.out.println("User did NOT input 'y' and instead inputted: '" + submitJob + "'");
    }
  }

private static List jsonReader(String filePath) {
    try {
      byte[] mapData = Files.readAllBytes(Paths.get(filePath));
      ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
      objectMapper.configure( JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true );
      return objectMapper.readValue(mapData, ArrayList.class);
    } catch (IOException io) {
      io.printStackTrace();
      return Collections.emptyList();
    }
  }

  private static Map<String, Integer> countByField(List<Map<String, String>> listOfMaps, String key) {
    Map<String, Integer> counts = new HashMap<>();
    for (Map<String, String> map: listOfMaps) {
      if (map.containsKey(key)) {
        String location = map.get(key);
        if (counts.containsKey(location)) { counts.replace(location, counts.get(location)+1); }
        else { counts.put(location, 1); }
      }
    }
    return counts;
  }

  public static String getStringInput(String prompt) {
    System.out.print(prompt);
    Scanner inputScanner = new Scanner(System.in);
    String inputStr = inputScanner.nextLine();
    while (inputStr.isEmpty()) {
      System.out.print("Please input something: ");
      inputStr = inputScanner.nextLine();
    }
    return inputStr;
  }

  private static void newJob() {
    try {
      JsonFactory jsonF = new JsonFactory();
      JsonGenerator jg = jsonF.createGenerator(new File("job.json"), JsonEncoding.UTF8);

      String type = getStringInput("What type of job? (full/part) ");
      String url = getStringInput("What is the URL of this job posting? ");
      String title = getStringInput("What is the job title? ");
      String description = getStringInput("What's the job description? ");

      jg.useDefaultPrettyPrinter();
      jg.writeStartObject();
      jg.writeStringField("type", type);
      jg.writeStringField("url", url);
      jg.writeStringField("title", title);
      jg.writeStringField("description", description);
      jg.writeEndObject();
      jg.close();
    }
    catch (IOException io) { io.printStackTrace(); }
  }
}
