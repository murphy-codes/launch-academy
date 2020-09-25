package com.example.lombokexercise.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class Station {
  @ToString.Exclude private String name;
  private String location;
}
