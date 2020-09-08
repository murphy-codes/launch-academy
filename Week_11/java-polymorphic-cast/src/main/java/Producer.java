public class Producer extends TeamMember {
  public Producer(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public String getCreditLine() {
    return "Producer - " + getFullName();
  };
}
