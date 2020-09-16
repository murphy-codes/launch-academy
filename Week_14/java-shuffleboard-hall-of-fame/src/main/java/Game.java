import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "games")
public class Game {
  @Id
  @SequenceGenerator(name = "game_generator", sequenceName = "games_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotEmpty
  @Column(name="red_team_player_1", nullable=false)
  private String redTeamPlayer1;

  @NotEmpty
  @Column(name="red_team_player_2", nullable=false)
  private String redTeamPlayer2;

  @NotEmpty
  @Min(0)
  @Column(name="red_team_score", nullable=false)
  private Integer redTeamScore;

  @NotEmpty
  @Column(name="blue_team_player_1", nullable=false)
  private String blueTeamPlayer1;

  @NotEmpty
  @Column(name="blue_team_player_2", nullable=false)
  private String blueTeamPlayer2;

  @NotEmpty
  @Min(0)
  @Column(name="blue_team_score", nullable=false)
  private Integer blueTeamScore;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getRedTeamPlayer1() { return redTeamPlayer1; }
  public void setRedTeamPlayer1(String redTeamPlayer1) { this.redTeamPlayer1 = redTeamPlayer1; }
  public String getRedTeamPlayer2() { return redTeamPlayer2; }
  public void setRedTeamPlayer2(String redTeamPlayer2) { this.redTeamPlayer2 = redTeamPlayer2; }
  public int getRedTeamScore() { return redTeamScore; }
  public void setRedTeamScore(int redTeamScore) { this.redTeamScore = redTeamScore; }
  public String getBlueTeamPlayer1() { return blueTeamPlayer1; }
  public void setBlueTeamPlayer1(String blueTeamPlayer1) { this.blueTeamPlayer1 = blueTeamPlayer1; }
  public String getBlueTeamPlayer2() { return blueTeamPlayer2; }
  public void setBlueTeamPlayer2(String blueTeamPlayer2) { this.blueTeamPlayer2 = blueTeamPlayer2; }
  public int getBlueTeamScore() { return blueTeamScore; }
  public void setBlueTeamScore(int blueTeamScore) { this.blueTeamScore = blueTeamScore; }
}
