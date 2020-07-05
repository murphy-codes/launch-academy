// generate a random integer between 10 and 60
let generateRandomRolltime = () => {
  return Math.floor(Math.random() * (51) + 10);
}

let rawDataArray = [
  {
    cheeseName: 'Red Leicester',
    cheeseDeliciousness: 9,
    contestantName: 'John C',
    contestantHunger: 8
  },
  {
    cheeseName: 'Tilsit',
    cheeseDeliciousness: 3,
    contestantName: 'Michael P',
    contestantHunger: 10
  },
  {
    cheeseName: 'Caerphilly',
    cheeseDeliciousness: 5,
    contestantName: 'Eric I',
    contestantHunger: 2
  },
  {
    cheeseName: 'Bel Paese',
    cheeseDeliciousness: 4,
    contestantName: 'Graham C',
    contestantHunger: 4
  },
  {
    cheeseName: 'Red Windsor',
    cheeseDeliciousness: 9,
    contestantName: 'Terry G',
    contestantHunger: 6
  },
  {
    cheeseName: 'Stilton',
    cheeseDeliciousness: 7,
    contestantName: 'Terry J',
    contestantHunger: 1
  },
  {
    cheeseName: 'Gruyere',
    cheeseDeliciousness: 2,
    contestantName: 'Carol C',
    contestantHunger: 6
  }
]

let registerContestants = () => {
  const registeredContestantArray = [];
  for (const rawContestant of rawDataArray) {
    let newContestant = {
      name: rawContestant.contestantName,
      hunger: rawContestant.contestantHunger,
      cheese: {
        name: rawContestant.cheeseName,
        deliciousness: rawContestant.cheeseDeliciousness
      },
      disqualified: false,
      results: [],
      getResults() {
        if (this.results.length === 0) {
          return null;
        }
        let currentResults = this.results.join(" s, ") + 
          " sec.\n" + 
          `    Avg: ${(this.results.reduce((a, b) => (a + b)) / this.results.length).toFixed(1)} sec`;
        return currentResults;
      },
      reportIndividualResults() {
        return `Contestant: ${this.name}\n` + 
          //
          `Cheese: ${this.cheese.name}\n` + 
          `Results: ${this.disqualified ? "Disqualified" : this.getResults()}`;
      }
    };
    registeredContestantArray.push(newContestant);
  }
  return registeredContestantArray;
};

let contestantArray = registerContestants();

let checkForCheeseEating = (contestant) => {
  if ((contestant.hunger+contestant.cheese.deliciousness) > 14) {
    contestant.disqualified = true;
  }
  return contestant;
};
contestantArray = contestantArray.map(contestant => checkForCheeseEating(contestant));

let rollDatCheese = (contestant) => {
  if (contestant.disqualified === false) {contestant.results.push(generateRandomRolltime());}
  return contestant;
}

console.log("The final results are in!\n\n");

for (contestant of contestantArray) {
  for (i=0; i<3; i++) {
    contestant = rollDatCheese(contestant);
  }
  console.log(contestant.reportIndividualResults() + "\n\n");
}