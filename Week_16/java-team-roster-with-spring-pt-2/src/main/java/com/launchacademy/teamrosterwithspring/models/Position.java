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
@Table(name = "positions")
public class Position {
  @Id
  @SequenceGenerator(name="position_generator", sequenceName="positions_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="position_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="position_name", nullable=false)
  private String positionName;

  @OneToMany(mappedBy = "position")
  private List<Player> players = new ArrayList<>();

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getPositionName() { return positionName; }
  public void setPositionName(String positionName) { this.positionName = positionName; }
  public List<Player> getPlayers() { return players; }
  public void setPlayers(List<Player> players) { this.players = players; }

  public void addPlayer(Player player) {
    player.setPositionId(this.id);
    this.players.add(player);
  }
}