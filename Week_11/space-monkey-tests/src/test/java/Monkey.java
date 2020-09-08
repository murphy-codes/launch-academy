import java.util.Collection;

public class Monkey {
  private String firstName;
  private String lastName;
  private String favoriteFood;
  private String favoriteQuote;

  public Monkey(String firstName, String lastName, String favoriteFood, String favoriteQuote) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.favoriteFood = favoriteFood;
    this.favoriteQuote = favoriteQuote;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFavoriteFood() {
    return favoriteFood;
  }

  public String getFavoriteQuote() {
    return favoriteQuote;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public String getMonkeyInfo() {
    return "Monkey Name:    " + getFullName() + "\nFavorite food:  " + favoriteFood + "\nFavorite quote: " + favoriteQuote;
  }
}
