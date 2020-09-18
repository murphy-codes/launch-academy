public class Player {
  private String name;
  private String position;
  private String team;

  public Player(String position, String name) {
    this.name = name;
    this.position = position;
    this.team = "";
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getPosition() { return position; }
  public void setPosition(String position) { this.position = position; }
  public String getTeam() { return team; }
  public void setTeam(String team) { this.team = team; }
}
