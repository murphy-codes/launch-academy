package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teams")
public class TeamsController {
  @GetMapping
  public String getIndex(Model model) {
    model.addAttribute("teams", League.getLeague().getTeams());
    return "teams/index";
  }

  @GetMapping("/{id}")
  public ModelAndView showTeam(@PathVariable Integer id) {
    try { return new ModelAndView("teams/show", "team", League.getLeague().getTeams().get(id)); }
    catch (IndexOutOfBoundsException e) { return new ModelAndView("404"); }
  }
}
