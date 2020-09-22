package com.example.challenge.javaspringdiceroller.controllers;

import com.example.challenge.javaspringdiceroller.components.DiceRoller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/rolls")
public class RollsController {
  @GetMapping("")
  public String showIndex(Model model) {
    model.addAttribute("guess1d6", "?guess=3");
    model.addAttribute("rollNd6", "?guess=10&diceCount=3");
    return "rolls/index";
  }

  @GetMapping("/new")
  public String getNewRoll(@RequestParam(required = false) Integer guess, @RequestParam(required = false) Integer diceCount, Model model) {
    DiceRoller diceRoller = new DiceRoller();
    String result = "";
    if (diceCount == null) { diceCount = 1; }
    List<Integer> rolls = diceRoller.rollNd6(diceCount);
    int total = rolls.remove(rolls.size()-1);
    String icons = String.join(" ", diceRoller.getDieIcons(rolls));
    if (guess != null) {
      result = (total==guess ? "YOU GUESSED THE NUMBER" : (total>guess ? "Nope. Sorry. Try Again" :  "Close. If we were playing price is right rules, you would have won."));
      model.addAttribute("result", "<p" + (result.equals("YOU GUESSED THE NUMBER") ? " style=\"font-weight: bold;\"" : "") + ">Result: " + result +"</p>");
      model.addAttribute("guess", "<p>Guess: " + guess + "</p>");
    }
    model.addAttribute("dieCount", diceCount);
    model.addAttribute("total", total);
    model.addAttribute("icons", icons);
    return "show";
  }
}
