import java.util.ArrayList;
import java.util.List;

public class Team {
  private String teamName;
  private List<Player> players;

  public Team(String teamName) {
    this.teamName = teamName;
    this.players = new ArrayList<>();
  }

  public String getTeamName() { return teamName; }
  public void setTeamName(String teamName) { this.teamName = teamName; }
  public List<Player> getPlayers() { return players; }
  public void addPlayer(Player player) {
    player.setTeam(teamName);
    this.players.add(player);
  }
}
