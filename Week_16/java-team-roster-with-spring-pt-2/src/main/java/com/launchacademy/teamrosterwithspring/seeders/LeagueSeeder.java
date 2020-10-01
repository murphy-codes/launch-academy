package com.launchacademy.teamrosterwithspring.seeders;

import com.launchacademy.teamrosterwithspring.models.Player;
import com.launchacademy.teamrosterwithspring.models.Position;
import com.launchacademy.teamrosterwithspring.models.Team;
import com.launchacademy.teamrosterwithspring.repositories.PlayerRepository;
import com.launchacademy.teamrosterwithspring.repositories.PositionRepository;
import com.launchacademy.teamrosterwithspring.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class LeagueSeeder implements CommandLineRunner {
  private TeamRepository teamRepository;
  private PlayerRepository playerRepository;
  private PositionRepository positionRepository;

  @Autowired
  public LeagueSeeder(TeamRepository teamRepository, PlayerRepository playerRepository, PositionRepository positionRepository) {
    this.teamRepository = teamRepository;
    this.playerRepository = playerRepository;
    this.positionRepository = positionRepository;
  }

  @Override
  public void run(String... args) throws Exception {

//    List<String> seedList = Arrays.asList("League","Fantasy League");
//    for(String name : seedList) {
//      if(leagueRepository.findAllByTeamName(name).size() == 0) {
//        League league = new League();
//        league.setLeagueName(name);
//        leagueRepository.save(league);
//      }
//    }

    List<String> seedList = Arrays.asList("Norway","South Korea","Sweden","Switzerland","United States");
    for(String name : seedList) {
      if(teamRepository.findAllByTeamName(name).size() == 0) {
        Team team = new Team();
        team.setTeamName(name);
        teamRepository.save(team);
      }
    }
    seedList = Arrays.asList("Lead","Second","Third","Fourth","Alternate","Skip");
    for(String name : seedList) {
      if(positionRepository.findAllByPositionName(name).size() == 0) {
        Position position = new Position();
        position.setPositionName(name);
        positionRepository.save(position);
      }
    }
    Map<String, String> seedMap = new LinkedHashMap<>();
    for (int i = 0; i < 5; i++) {
      if (i == 0) { seedMap.putAll(Map.of("Thomas Ulsrud","Skip","Torger Nergård","Third","Christoffer Svae","Second","Håvard Vad Petersson","Lead","Markus Høiberg","Alternate")); }
      else if (i == 1) { seedMap.putAll(Map.of("Kim Chang-min","Skip","Seong Se-hyeon","Third","Oh Eun-su","Second","Lee Ki-bok","Lead","Kim Min-chan","Alternate")); }
      else if (i == 2) { seedMap.putAll(Map.of("Niklas Edin","Skip","Oskar Eriksson","Third","Rasmus Wranå","Second","Christoffer Sundgren","Lead","Henrik Leek","Alternate")); }
      else if (i == 3) { seedMap.putAll(Map.of("Benoît Schwarz","Fourth","Claudio Pätz","Third","Peter de Cruz","Skip","Valentin Tanner","Lead","Dominik Märki","Alternate")); }
      else { seedMap.putAll(Map.of("John Shuster","Skip","Tyler George","Third","Matt Hamilton","Second","John Landsteiner","Lead","Joe Polo","Alternate")); }
    }

    List<Team> teams = (List<Team>) teamRepository.findAll();
    int i, j;
    i = j = 0;
    for(String name : seedMap.keySet()) {
      if(playerRepository.findAllByName(name).size() == 0) {
        Player player = new Player();
        player.setName(name);
//        player.setPosition(seedMap.get(name));
        player.setPosition(positionRepository.findFirstByPositionName(seedMap.get(name)));
        player.setTeam(teams.get(j));
        playerRepository.save(player);
        if (++i == 5) {
          i = 0;
          j++;
        }
      }
    }


//    Map<String, String> seedMap = new LinkedHashMap<>();
//    for (int i = 0; i < 5; i++) {
//      if (i == 0) { seedMap.putAll(Map.of("Thomas Ulsrud","Skip","Torger Nergård","Third","Christoffer Svae","Second","Håvard Vad Petersson","Lead","Markus Høiberg","Alternate")); }
//      else if (i == 1) { seedMap.putAll(Map.of("Kim Chang-min","Skip","Seong Se-hyeon","Third","Oh Eun-su","Second","Lee Ki-bok","Lead","Kim Min-chan","Alternate")); }
//      else if (i == 2) { seedMap.putAll(Map.of("Niklas Edin","Skip","Oskar Eriksson","Third","Rasmus Wranå","Second","Christoffer Sundgren","Lead","Henrik Leek","Alternate")); }
//      else if (i == 3) { seedMap.putAll(Map.of("Benoît Schwarz","Fourth","Claudio Pätz","Third","Peter de Cruz","Skip","Valentin Tanner","Lead","Dominik Märki","Alternate")); }
//      else { seedMap.putAll(Map.of("John Shuster","Skip","Tyler George","Third","Matt Hamilton","Second","John Landsteiner","Lead","Joe Polo","Alternate")); }
//    }
  }
}