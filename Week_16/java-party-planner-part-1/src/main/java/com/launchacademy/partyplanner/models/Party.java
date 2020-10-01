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
@Table(name = "parties")
public class Party {
  @Id
  @SequenceGenerator(name="party_generator", sequenceName="parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="party_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="name", nullable=false)
  private String name;

  @NotEmpty
  @Column(name="description", nullable=false)
  private String description;

  @NotEmpty
  @Column(name="location", nullable=false)
  private String location;

  @OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
  private List<Attendance> attendances;
}
