import java.io.IOException;

public class LaunchLibraryRunner {
  public static void main(String[] args) throws IOException {
    MainMenu menu = new MainMenu();
    menu.promptUntilQuit();
  }
}