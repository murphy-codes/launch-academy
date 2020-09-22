package com.example.challenge.javaspringdiceroller.controllers;

import com.example.challenge.javaspringdiceroller.components.DiceRoller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/batchRolls")
public class BatchRollsController {
  @GetMapping("")
  public String showIndex(Model model) {
    model.addAttribute("nRollsNd6", "?guess=10&diceCount=3&rollCount=5");
    return "batchRolls/index";
  }

  @GetMapping("/new")
  public String getNewRoll(@RequestParam(required = false) Integer guess, @RequestParam(required = false) Integer diceCount, @RequestParam(required = false) Integer rollCount, Model model) {
    DiceRoller diceRoller = new DiceRoller();
    List<String> results = new ArrayList<>();
    if (diceCount == null) { diceCount = 1; }
    if (rollCount == null) { rollCount = 1; }
    List<Integer> rolls = diceRoller.rollNd6NTimes(diceCount, rollCount);
    int total = rolls.remove(rolls.size()-1);
    if (guess != null) { for (Integer rollResult: rolls) { results.add(rollResult==guess ? "<span style=\"font-weight: bold;\">YOU GUESSED THE NUMBER</span>" : (rollResult>guess ? "Nope. Sorry. Try Again" :  "Close. If we were playing price is right rules, you would have won.")); } }
    model.addAttribute("dieCount", diceCount);
    model.addAttribute("total", total);
    if (guess != null) {
      model.addAttribute("guess", "<p>Guess: " + guess + "</p>");
      model.addAttribute("rolls", rolls);
      model.addAttribute("results", results);
    }
    return "show";
  }
}
