package com.launchacademy.mallmadness.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreDTO {
  private String name;
  private String type;
  private String averageCost;
  private Boolean operatingStatus;
}
