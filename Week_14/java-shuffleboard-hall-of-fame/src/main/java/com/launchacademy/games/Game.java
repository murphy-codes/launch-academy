package com.launchacademy.games;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="games")
public class Game {
  @Id
  @SequenceGenerator(name="game_generator", sequenceName = "games_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="game_generator")
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotEmpty
  @Column(name="red_team_player_1", nullable=false)
  private String redTeamPlayer1;

  @NotEmpty
  @Column(name="red_team_player_2", nullable=false)
  private String redTeamPlayer2;

  @NotNull
  @Min(0)
  @Column(name="red_team_score", nullable=false)
  private int redTeamScore;

  @NotEmpty
  @Column(name="blue_team_player_1", nullable=false)
  private String blueTeamPlayer1;

  @NotEmpty
  @Column(name="blue_team_player_2", nullable=false)
  private String blueTeamPlayer2;

  @NotNull
  @Min(0)
  @Column(name="blue_team_score", nullable=false)
  private int blueTeamScore;

  public void setRedTeamPlayer1(String playerName) {
    this.redTeamPlayer1 = playerName;
  }
  public String getRedTeamPlayer1() {
    return this.redTeamPlayer1;
  }
  public void setRedTeamPlayer2(String playerName) {
    this.redTeamPlayer2 = playerName;
  }
  public String getRedTeamPlayer2() {
    return this.redTeamPlayer2;
  }
  public void setRedTeamScore(int newScore) {
    this.redTeamScore = newScore;
  }
  public int getRedTeamScore() {
    return this.redTeamScore;
  }
  public void setBlueTeamPlayer1(String playerName) {
    this.blueTeamPlayer1 = playerName;
  }
  public String getBlueTeamPlayer1() {
    return this.blueTeamPlayer1;
  }
  public void setBlueTeamPlayer2(String playerName) {
    this.blueTeamPlayer2 = playerName;
  }
  public String getBlueTeamPlayer2() {
    return this.blueTeamPlayer2;
  }
  public void setBlueTeamScore(int newScore) {
    this.blueTeamScore = newScore;
  }
  public int getBlueTeamScore() {
    return this.blueTeamScore;
  }
}
