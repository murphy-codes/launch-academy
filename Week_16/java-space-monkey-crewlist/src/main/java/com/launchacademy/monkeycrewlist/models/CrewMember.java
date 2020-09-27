package com.launchacademy.monkeycrewlist.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "crew_members")
public class CrewMember {

  @Id
  @SequenceGenerator(name = "crew_member_generator",
      sequenceName = "crew_members_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator = "crew_member_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "hobby")
  private String hobby;

  @Column(name = "rank")
  private String rank;

  @Column(name = "tours_aboard")
  private Integer toursAboard;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public Integer getToursAboard() {
    return toursAboard;
  }

  public void setToursAboard(Integer toursAboard) {
    this.toursAboard = toursAboard;
  }
}