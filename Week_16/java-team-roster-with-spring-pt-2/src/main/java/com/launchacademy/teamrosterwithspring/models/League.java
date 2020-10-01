package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "leagues")
public class League {
  @Id
  @SequenceGenerator(name="team_generator", sequenceName="teams_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="team_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="league_name", nullable=false)
  private String leagueName;

  @OneToMany(mappedBy = "league")
  private List<Team> teams = new ArrayList<>();

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getLeagueName() { return leagueName; }
  public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
  public List<Team> getTeams() { return teams; }
  public void setTeams(List<Team> teams) { this.teams = teams; }

  public void addTeam(Team team) {
    team.setLeagueId(this.id);
    this.teams.add(team);
  }
}