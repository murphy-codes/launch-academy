public class TeamMember {
  private String firstName;
  private String lastName;

  public TeamMember(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() { return firstName; }

  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getFullName() { return firstName + " " + lastName; }

  public String getCreditLine() {
    throw new Error("Override this method");
  };
}
