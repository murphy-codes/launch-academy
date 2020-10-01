package com.launchacademy.partyplanner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "attendances")
public class Attendance {
  @Id
  @SequenceGenerator(name="attendance_generator", sequenceName="attendances_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="attendance_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @Column(name = "friend_id", insertable = false, updatable = false)
  private Integer friendId;

  @ManyToOne
  @JoinColumn(name = "friend_id")
  private Friend friend;

  @Column(name = "party_id", insertable = false, updatable = false)
  private Integer partyId;

  @ManyToOne
  @JoinColumn(name = "party_id")
  private Party party;
}
