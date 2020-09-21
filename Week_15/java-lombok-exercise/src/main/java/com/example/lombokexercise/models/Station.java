package com.example.lombokexercise.models;

import org.springframework.stereotype.Component;

@Component
public class Station {
  private String name;
  private String location;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
