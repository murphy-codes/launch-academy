package com.launchacademy.partyplanner.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "friends")
public class Friend {
  @Id
  @SequenceGenerator(name="friend_generator", sequenceName="friends_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="friend_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

  @NotEmpty
  @Column(name="last_name", nullable=false)
  private String lastName;

  @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
  private List<Attendance> attendances;
}
