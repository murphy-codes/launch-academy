package com.launchacademy.teamrosterwithspring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "players")
public class Player {
  @Id
  @SequenceGenerator(name="player_generator", sequenceName="players_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="player_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="name", nullable=false)
  private String name;

  @Column(name = "position_id", insertable = false, updatable = false)
  private Integer positionId;

  @ManyToOne
  @JoinColumn(name = "position_id")
  private Position position;

  @Column(name = "team_id", insertable = false, updatable = false)
  private Integer teamId;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public Integer getTeamId() { return teamId; }
  public void setTeamId(Integer teamId) { this.teamId = teamId; }
  public Team getTeam() { return team; }
  public void setTeam(Team team) { this.team = team; }
  public Integer getPositionId() { return positionId; }
  public void setPositionId(Integer positionId) { this.positionId = positionId; }
  public Position getPosition() { return position; }
  public void setPosition(Position position) { this.position = position; }
}