package com.launchacademy.javastarships.controllers;

import com.launchacademy.javastarships.models.StarShip;
import com.launchacademy.javastarships.services.StarShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/starships")
public class StarShipsController {
  @Autowired
  private StarShipService service;

  @GetMapping
  public String listStarShips(Model model) {
    model.addAttribute("starships", service.findAll());
    return "starships/index";
  }

  @GetMapping("/{id}")
  public String showStarShips(@PathVariable Integer id, Model model) {
    model.addAttribute("starship", service.get(id));
    return "starships/show";
  }

  @GetMapping("new")
  public String newStarShip(@ModelAttribute StarShip starShip) { return "starships/new"; }

  @PostMapping
  public String createStarShip(@ModelAttribute StarShip starShip) {
    starShip.setId(service.findAll().size() + 1);
    service.addToList(starShip);
    return "redirect:/starships/" + starShip.getId();
  }
}
