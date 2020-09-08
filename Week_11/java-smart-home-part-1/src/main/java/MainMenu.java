import java.util.Scanner;
import java.util.ArrayList;

public class MainMenu {
//  private final ArrayList<Device> deviceList = new ArrayList<>();

  public static final String ADD_DEVICE_TEXT = "Add a new device";
  public static final String MANAGE_DEVICES = "Manage an existing device";
  public static final String QUIT_TEXT = "Quit";

  public enum MenuOption {
    a(ADD_DEVICE_TEXT),
    m(MANAGE_DEVICES),
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

  public void promptUntilQuit() {
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
        //allow the user to add a new device
        System.out.println("Added a new device!");
      }
      else if(input == MenuOption.m) {
        //allow the user to manage an existing device
        System.out.println("Viewed an existing device!");
      }

    } while(input != MenuOption.q);
    System.out.println("Thank you for using LA Smart Home, your Maven Haven!");
    scanner.close();
  }
}
