import Deck from './Deck.js'
import Hand from './Hand.js'
import Player from './Player.js'

class Game {
  constructor(players = 2, handSize = 4, numberOfDecks = 1) {
    if (numberOfDecks > 8) { numberOfDecks = 8; console.error("ERROR:\n  Too many decks.\n  The number of decks in the shoe is limited to 8.\n  Deck size reset.\n"); };
    if (handSize > 10) { handSize = 10; console.error("ERROR:\n  Hand size too large.\n  The hand size is limited to 10.\n  Hand size reset.\n"); };
    if (players > 16) { players = 16; console.error("ERROR:\n  Too many players.\n  The number of players is limited to 16.\n  Number of players reset.\n"); };
    if (Number.isInteger(players) && (players * handSize) > numberOfDecks*52){ 
      console.error(`ERROR:\nYou can't have ${players} players w/ ${handSize} cards each ` +  
                    `in a ${numberOfDecks} shoe deck (${numberOfDecks*52} cards).\n` +   
                    `The # of players has been reset to 2, and hand size has been reset to 4.\n`);
      players = 2; 
      handSize = 4;  
    };
    this.deck = new Deck(numberOfDecks);
    this.deckSize = this.deck.cards.length;
    this.players = Number.isInteger(players) ? this.generatePlayers(players, handSize) : players;
  };

  generatePlayers(numPlayers = 2, handSize = 4) {
    let players = [];
    for (let i=0; i<numPlayers; i++) {
      players.push(new Player(`Player ${i+1}`, new Hand(this.deck.dealHand(handSize))));
    };
    return players;
  };

  getWinner() {
    let winner;
    let highestScore = 0;
    this.players.forEach(player => {
      const handValue = player.hand.getValue();
      if (handValue > highestScore) {
        winner = player;
        highestScore = handValue;
      } else if (handValue === highestScore) {
        Array.isArray(winner) ? winner.push(player) : winner = [winner, player];
      }
    });
    return winner;
  };

  play() {
    console.log("GAME START!\n");
    this.deckSize/52 > 1 ? console.log(`This is a ${this.deckSize/52} deck shoe.`) : '';
    console.log(`There are ${this.deckSize} cards in the deck.\n`);

    this.players.forEach(player => {
      console.log(`${player.name} was dealt ${player.hand.showHand()}`);
      console.log(`Their hand's value is: ${player.hand.getValue()}\n`);
    });

    const winner = this.getWinner();
    if (Array.isArray(winner)) {
      console.log("The game is a tie! \nHere are the winners:");
      winner.forEach(player => console.log(`  ${player.getName()}`));
    } else {
      console.log(`${winner.getName()} wins the game!`);
    };
  };
};

export default Game;