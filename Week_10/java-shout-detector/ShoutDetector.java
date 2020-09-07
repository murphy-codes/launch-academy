//import java.util.Arrays;
import java.util.Scanner;

public class ShoutDetector {
  public ShoutDetector() {
    //
  }

  public static void main(String[] args) {
    String voice = getInput();
    System.out.println("You said: \"" + voice + "\"");
//    System.out.println("\n\n" + voice);
  }

  private static String getInput() {
    Scanner scannerUserInput = new Scanner(System.in);
    System.out.print("Hello human. Please say something for my amusement:\n");
    String userMessage = scannerUserInput.useDelimiter("\n").next();




    return userMessage;



//    String[] result = rebuffer("Test input text");
//    System.out.println("result[0] = " + result[0]);
//    System.out.println("result[1] = " + result[1]);
//
//    return "\n\ndid this work?";
  }

  private static String[] rebuffer(String input) {
    String[] result = new String[2];

    result[0] = null;

    result[1] = "Please stop yelling at me.";

//    result[1] = "Please stop yelling at me.";
//
//    result[1] = "I don't response to inflammatory questions";






//    result[1] = input;

    if (result[0] == null) { result[0] = "error"; }



    return result;
  }
}