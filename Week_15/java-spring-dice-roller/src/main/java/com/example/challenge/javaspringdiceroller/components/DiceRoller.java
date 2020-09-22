package com.example.challenge.javaspringdiceroller.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DiceRoller {
  private Random rand;

  public DiceRoller() { this.rand = new Random(); }

  public Integer roll1d6() { return rand.nextInt(6) + 1; }

  public Integer rollNd6(int n) {
    Integer total = 0;
    for (int i = 0; i < n; i++) { total += roll1d6(); }
    return total;
  }

  public List<Integer> rollNd6NTimes(int numDie, int numRolls) {
    List<Integer> rolls = new ArrayList<>();
    int total = 0;
    for (int i = 0; i < numRolls; i++) {
      int roll = rollNd6(numDie);
      rolls.add(roll);
      total += roll;
    }
    rolls.add(total);
    return rolls;
  }
}
