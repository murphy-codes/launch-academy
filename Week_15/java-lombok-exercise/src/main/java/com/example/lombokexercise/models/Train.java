package com.example.lombokexercise.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Train {
  private String name;
  private String color;
}
