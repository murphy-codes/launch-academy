package com.launchacademy.javastarships.models;

import org.springframework.stereotype.Component;

@Component
public class StarShip {
  private Integer id;
  private String name;
  private String description;
  private Integer fuelCapacity;

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
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Integer getFuelCapacity() {
    return fuelCapacity;
  }
  public void setFuelCapacity(Integer fuelCapacity) {
    this.fuelCapacity = fuelCapacity;
  }

  public String getFuelCapacityReading() {
//    return (fuelCapacity > 700 ? "HIGH" : (fuelCapacity < 300 ? "LOW" : "AVERAGE")) + " (" + fuelCapacity + " Teraliters)";
    return fuelCapacity > 700 ? "high" : (fuelCapacity < 300 ? "low" : "average");
  }
}
