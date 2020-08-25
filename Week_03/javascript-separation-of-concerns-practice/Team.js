class Team {
  constructor(name, coach, players = []) {
    this.name = name;
    this.coach = coach;
    this.players = players;
  }

  signPlayer(player) {
    this.players.push(player);
  }
}

export default Team;