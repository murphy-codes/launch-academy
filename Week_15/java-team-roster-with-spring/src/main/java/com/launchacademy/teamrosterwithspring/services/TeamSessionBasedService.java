package com.launchacademy.teamrosterwithspring.services;

import com.launchacademy.teamrosterwithspring.models.League;
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class TeamSessionBasedService implements TeamService {
  private League league;

  public TeamSessionBasedService() { this.league = League.getFantasyLeague(); }

  public List<Team> getTeams() { return league.getTeams(); }

  public void addTeam(Team team) { league.addTeam(team); }

  public Team getTeam(Integer id) { return this.league.getTeams().get(id); }
}
