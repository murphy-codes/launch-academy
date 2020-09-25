package com.launchacademy.teamrosterwithspring.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class League {
  private List<Team> teams;

  public League() {
    this.teams = new ArrayList<>();
  }

  public void addTeam(Team team) {
    teams.add(team);
  }

  public static League getLeague() {
    League theLeague = new League();
    Team team = new Team();
    team.setTeamName("Norway");
    Player player = new Player();
    player.setPosition("Skip");
    player.setName("Thomas Ulsrud");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Third");
    player.setName("Torger Nergård");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Second");
    player.setName("Christoffer Svae");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Lead");
    player.setName("Håvard Vad Petersson");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Alternate");
    player.setName("Markus Høiberg");
    team.addPlayer(player);

    theLeague.addTeam(team);

    team = new Team();
    team.setTeamName("South Korea");

    player = new Player();
    player.setPosition("Skip");
    player.setName("Kim Chang-min");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Third");
    player.setName("Seong Se-hyeon");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Second");
    player.setName("Oh Eun-su");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Lead");
    player.setName("Lee Ki-bok");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Alternate");
    player.setName("Kim Min-chan");
    team.addPlayer(player);

    theLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Sweden");
    player = new Player();
    player.setPosition("Skip");
    player.setName("Niklas Edin");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Third");
    player.setName("Oskar Eriksson");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Second");
    player.setName("Rasmus Wranå");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Lead");
    player.setName("Christoffer Sundgren");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Alternate");
    player.setName("Henrik Leek");
    team.addPlayer(player);

    theLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Switzerland");
    player = new Player();
    player.setPosition("Fourth");
    player.setName("Benoît Schwarz");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Third");
    player.setName("Claudio Pätz");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Skip");
    player.setName("Peter de Cruz");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Lead");
    player.setName("Valentin Tanner");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Alternate");
    player.setName("Dominik Märki");
    team.addPlayer(player);

    theLeague.addTeam(team);

    team = new Team();
    team.setTeamName("United States");
    player = new Player();
    player.setPosition("Skip");
    player.setName("John Shuster");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Third");
    player.setName("Tyler George");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Second");
    player.setName("Matt Hamilton");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Lead");
    player.setName("John Landsteiner");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Alternate");
    player.setName("Joe Polo");
    team.addPlayer(player);

    theLeague.addTeam(team);
    return theLeague;
  }

  public static League getFantasyLeague()   {
    League fantasyLeague = new League();

    Team team = new Team();
    team.setTeamName("Future Industries Fire Ferrets");

    Player player = new Player();
    player.setPosition("Firebender");
    player.setName("Mako");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Bolin");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Korra");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Golden Temple Tigerdillos");

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Haka");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Firebender");
    player.setName("Josei");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Kano");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Red Sands Rabaroos");

    player = new Player();
    player.setPosition("Firebender");
    player.setName("Adi");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Ula");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Umi");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Black Quarry Boar-q-pines");

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Chang");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Shui");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Firebender");
    player.setName("Xin");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    team = new Team();
    team.setTeamName("Bau Ling Buzzard Wasps");

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Shan");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Firebender");
    player.setName("Ko");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Loong");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    team = new Team();
    team.setTeamName("White Falls Wolfbats");

    player = new Player();
    player.setPosition("Waterbender");
    player.setName("Tahno");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Earthbender");
    player.setName("Ming");
    team.addPlayer(player);

    player = new Player();
    player.setPosition("Firebender");
    player.setName("Shaozu");
    team.addPlayer(player);

    fantasyLeague.addTeam(team);

    return fantasyLeague;
  }

  public List<Team> getTeams() {
    return teams;
  }
}

