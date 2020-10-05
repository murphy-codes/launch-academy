package com.launchacademy.mallmadness.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="stores")
@NoArgsConstructor
@Getter
@Setter
public class Store {
  @Id
  @SequenceGenerator(name="store_generator", sequenceName = "stores_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="store_generator")
  @Column(name="id", nullable = false, unique = true)
  private Integer id;

  @NotNull(message = "Please input a name")
  @NotEmpty(message = "Names cannot be blank")
  @Column(name="name", nullable=false)
  private String name;

  @NotNull(message = "Please input a type")
  @NotEmpty(message = "Types cannot be blank")
  @Column(name="type", nullable=false)
  private String type;

  @NotNull(message = "Please input an age")
  @Min(value = 1, message = "The average cost must be between 1-5. Pleas input a higher number.")
  @Max(value = 5, message = "The average cost must be between 1-5. Pleas input a lower number.")
  @Column(name="average_cost", nullable=false)
  private Integer averageCost;

  @NotNull(message = "You must designate an operating status")
  @Column(name="operating_status", nullable=false)
  private Boolean operatingStatus;
}
