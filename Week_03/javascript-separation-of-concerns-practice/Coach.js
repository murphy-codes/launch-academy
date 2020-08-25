class Coach {
  constructor(name, firstYear) {
    this.name = name;
    this.firstYear = firstYear;
    this.stats = {
      wins: 0,
      losses: 0,
      draws: 0,
      matchesPlayed: 0
    };
  }

  gameOver(gameResult) {
    if(typeof(gameResult) != "string") { return false } 
    else if (!["W", "L", "D"].some(result => result === gameResult.toUpperCase())) { return false } 
    else {
      if (gameResult.toUpperCase() === "W") {
        this.stats.wins += 1;
      }
      else if (gameResult.toUpperCase() === "L") {
        this.stats.losses += 1;
      }
      else {
        this.stats.draws += 1;
      }
      this.stats.matchesPlayed += 1;
      return true;
    }
  }
}

export default Coach;