import java.util.HashMap;

public class TenInTheBed {
  public static void main(String[] args) {
    HashMap<Integer, String> numMap = new HashMap<>();
    String[] oneThroughTen = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    int count = 0;
    for (String num : oneThroughTen) { numMap.put(++count, num); }
    String[] single = {"was", "\"Good night!!\"\n"}; // "\"I'm lonely\"\n"
    String[] multi = {"were", "\"Roll over, roll over\"\nSo they all rolled over and one fell out\n"};
    String fiveSeven = "We fell in the ground\nWith a silly sound\nNaughty one\nThat naughty one";
    for (int i = 10; i > 0; i--) {
      System.out.println(numMap.get(i));
      System.out.println("There " + ((i > 1) ? multi[0] : single[0]) + " " + numMap.get(i).toLowerCase() + " in the bed");
      System.out.println("And the little one said\n" + ((i > 1) ? multi[1] : single[1]));
    }
  }
}