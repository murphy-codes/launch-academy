import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Spaceship {
  private static final String INPUT_FILE = "crewManifest.txt";
  private static final String OUTPUT_FILE = "captainLog.txt";

  public static void main(String[] args) throws IOException {
    //    The bulletin outputs the entire contents of crewManifest.txt to get all the crew on the ship
    System.out.println("---- CREW MANIFEST ------------------------");
    File crewManifestFile = new File(INPUT_FILE);
    String crewManifest = new Scanner(crewManifestFile).useDelimiter("\\z").next();
    System.out.println(crewManifest);

    //    When the program runs a second time, it should output the contents of the newly written file to alert the next captain of the message.
    String capLogBanner = "---- CAPTAIN'S LOG ------------------------";
    System.out.println(capLogBanner);
    File captainLog = new File(OUTPUT_FILE);
    boolean exists = captainLog.exists();
    if (exists) {
      String latestEntry = null;
      Scanner scannerFileInput = new Scanner(captainLog);
      while (scannerFileInput.hasNextLine()) { latestEntry = scannerFileInput.nextLine(); }
      System.out.println("Latest entry from the captain's log:");
      System.out.println(latestEntry + "\n");
    }

    //    After outputting the bulletin, the captain is asked to leave a message
    Scanner scannerUserInput = new Scanner(System.in);
    System.out.print("Captain, what's your message for the captain's log?\n");
    String captainMessage = scannerUserInput.useDelimiter("\n").next();
    LocalDateTime currentTime = LocalDateTime.now();
    String timestamp = "-- Log: " + currentTime.toLocalDate() + " " + currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond() + " ↓";

    //    Write the contents of that message to a file
    if (exists) {
      FileWriter fileWriter = new FileWriter(captainLog, true);
      fileWriter.write("\n\n" + timestamp + "\n" + captainMessage);
      fileWriter.close();
      if (captainLog.exists()) { System.out.println("File updated."); }
    } else {
      FileWriter fileWriter = new FileWriter(captainLog);
      fileWriter.write(capLogBanner + "\n" + timestamp + "\n" + captainMessage);
      fileWriter.close();
      if (captainLog.exists()) { System.out.println("File created."); }
    }
  }
}