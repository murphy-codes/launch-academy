package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/fantasy")
public class FantasyController {
  @Autowired
  private TeamService service;

  @GetMapping
  public RedirectView fantasyRedirect() { return new RedirectView("/fantasy/teams"); }

  @GetMapping("/teams")
  public String getIndex(Model model) {
    model.addAttribute("teams", service.getTeams());
    return "fantasy/teams/index";
  }

  @GetMapping("/teams/{id}")
  public String getTeam(@PathVariable Integer id, Model model) {
    model.addAttribute("team", service.getTeam(id));
    return "fantasy/teams/show";
  }

  @GetMapping("/teams/new")
  public String fantasyTeamForm(@ModelAttribute Team team) {
    return "fantasy/teams/new";
  }

  @PostMapping("/teams")
  public String addTeam(@ModelAttribute Team team) {
    service.addTeam(team);
    return "redirect:/fantasy/teams/" + (service.getTeams().size()-1);
  }
}
