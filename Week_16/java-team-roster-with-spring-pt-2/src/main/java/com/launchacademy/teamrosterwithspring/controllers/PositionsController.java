package com.launchacademy.teamrosterwithspring.controllers;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.repositories.PlayerRepository;
import com.launchacademy.teamrosterwithspring.repositories.PositionRepository;
import com.launchacademy.teamrosterwithspring.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/positions")
public class PositionsController {
  @Autowired
  private TeamRepository teamRepository;
  @Autowired
  private PlayerRepository playerRepository;
  @Autowired
  private PositionRepository positionRepository;

  @GetMapping
  public String getIndex(Model model) {
//    List<Team> teams = League.getLeague().getTeams();
    List<Team> teams = (List<Team>)teamRepository.findAll();
    List<String> positions = new ArrayList<>();
    for (Team team: teams) { for (Player player: team.getPlayers()) { if (!positions.contains(player.getPosition().getPositionName())) { positions.add(player.getPosition().getPositionName()); } } }
    model.addAttribute("positions", positions);
    return "positions/index";
  }

  @GetMapping("/{positionName}")
  public String getShow(@PathVariable String positionName, Model model) {
//    List<Team> teams = League.getLeague().getTeams();
    List<Team> teams = (List<Team>)teamRepository.findAll();
    List<String> players = new ArrayList<>();
    List<String> teamNames = new ArrayList<>();
    for (Team team: teams) { for (Player player: team.getPlayers()) {
      if (player.getPosition().getPositionName().equals(positionName)) {
        players.add(player.getName());
        teamNames.add(team.getTeamName());
      }
    } }
    model.addAttribute("position", positionName);
    model.addAttribute("players", players);
    model.addAttribute("teamNames", teamNames);
    return "positions/show";
  }
}
