package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/fantasy")
public class FantasyController {
  @GetMapping
  public RedirectView redirectWithUsingRedirectView() { return new RedirectView("/fantasy/teams"); }

  @GetMapping("/teams")
  public String getIndex(Model model) {
    model.addAttribute("teams", League.getLeague().getTeams());
    return "teams/index";
  }

  @GetMapping("/teams/new")
  public String fantasyTeamForm(@ModelAttribute Team team) {
    return "fantasy/teams/new";
  }

  @PostMapping("/teams")
  public String addTeam(@ModelAttribute Team team) {

//    model.addAttribute("teams", League.getLeague().getTeams());
    return "redirect:/teams";
  }

//  @GetMapping("/{id}")
//  public ModelAndView showTeam(@PathVariable Integer id) {
//    try { return new ModelAndView("teams/show", "team", League.getLeague().getTeams().get(id)); }
//    catch (IndexOutOfBoundsException e) { return new ModelAndView("404"); }
//  }
}
