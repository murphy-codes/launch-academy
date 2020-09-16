import java.util.ArrayList;
import java.util.List;

public class Team {
  private String teamName;
  private List<Player> players;

  public Team(String teamName) {
    this.teamName = teamName;
    this.players = new ArrayList<Player>();
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }
}
