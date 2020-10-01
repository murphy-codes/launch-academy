package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "teams")
public class Team {
  @Id
  @SequenceGenerator(name="team_generator", sequenceName="teams_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="team_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="team_name", nullable=false)
  private String teamName;

  @OneToMany(mappedBy = "team")
  private List<Player> players = new ArrayList<>();

  @Column(name = "league_id", insertable = false, updatable = false)
  private Integer leagueId;

  @ManyToOne
  @JoinColumn(name = "league_id")
  private Position league;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getTeamName() { return teamName; }
  public void setTeamName(String teamName) { this.teamName = teamName; }
  public List<Player> getPlayers() { return players; }
  public void setPlayers(List<Player> players) { this.players = players; }
  public Integer getLeagueId() { return leagueId; }
  public void setLeagueId(Integer leagueId) { this.leagueId = leagueId; }
  public Position getLeague() { return league; }
  public void setLeague(Position league) { this.league = league; }

  public void addPlayer(Player player) {
    player.setTeamId(this.id);
    this.players.add(player);
  }
}