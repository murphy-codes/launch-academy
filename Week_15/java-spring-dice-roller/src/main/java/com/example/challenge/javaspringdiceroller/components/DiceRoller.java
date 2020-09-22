package com.example.challenge.javaspringdiceroller.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class DiceRoller {
  private Random rand;
  private Map<Integer,String> icons;

  public DiceRoller() {
    this.rand = new Random();
    this.icons = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five", 6, "six");
  }

  public Integer roll1d6() { return rand.nextInt(6) + 1; }

  public List<Integer> rollNd6(int n) {
    List<Integer> rolls = new ArrayList<>();
    Integer total = 0;
    for (int i = 0; i < n; i++) {
      int roll = roll1d6();
      rolls.add(roll);
      total += roll;
    }
    rolls.add(total);
    return rolls;
  }

  public List<List<Integer>> rollNd6NTimes(int numDie, int numRolls) {
    List<List<Integer>> games = new ArrayList<>();
    int grandTotal = 0;
    for (int i = 0; i < numRolls; i++) {
      List<Integer> gameRolls = rollNd6(numDie);
      games.add(gameRolls);
      grandTotal += gameRolls.get(gameRolls.size()-1);
    }
    games.add(List.of(grandTotal));
    return games;
  }

  public List<String> getDieIcons(List<Integer> rolls) {
    List<String> faIcons = new ArrayList<>();
    for (Integer roll: rolls) { faIcons.add("<i class=\"fas fa-dice-" + icons.get(roll) + "\"></i>"); }
    return faIcons;
  }

//  public List<Integer> rollNd6NTimes(int numDie, int numRolls) {
//    List<Integer> rolls = new ArrayList<>();
//    int total = 0;
//    for (int i = 0; i < numRolls; i++) {
//      int roll = rollNd6original(numDie);
//      rolls.add(roll);
//      total += roll;
//    }
//    rolls.add(List.of(total));
//    return rolls;
//  }
//
//  public Integer rollNd6original(int n) {
//    Integer total = 0;
//    for (int i = 0; i < n; i++) { total += roll1d6(); }
//    return total;
//  }
//
//  public List<Integer> rollNd6NTimes(int numDie, int numRolls) {
//    List<Integer> rolls = new ArrayList<>();
//    int total = 0;
//    for (int i = 0; i < numRolls; i++) {
//      int roll = rollNd6original(numDie);
//      rolls.add(roll);
//      total += roll;
//    }
//    rolls.add(List.of(total));
//    return rolls;
//  }

//  public Integer rollNd6(int n) {
//    Integer total = 0;
//    for (int i = 0; i < n; i++) { total += roll1d6(); }
//    return total;
//  }

//  public List<Integer> rollNd6NTimes(int numDie, int numRolls) {
//    List<Integer> rolls = new ArrayList<>();
//    int total = 0;
//    for (int i = 0; i < numRolls; i++) {
//      int roll = rollNd6(numDie);
//      rolls.add(roll);
//      total += roll;
//    }
//    rolls.add(total);
//    return rolls;
//  }
}
