import _ from 'lodash'
import Card from './Card.js'

const suits = ['♦', '♣', '♠', '♥']
const ranks = [2, 3, 4, 5, 6, 7, 8, 9, 10, 'J', 'Q', 'K', 'A']

class Deck {
  constructor(shoeSize = 1) {
    this.cards = this.buildDeck(shoeSize)
  }

  buildDeck(shoeSize = 1) {
    if (shoeSize > 8) {
      shoeSize = 8;
      console.log("too many decks declared in deck class");
    };
    let cards = []
    for (let i = 0; i<shoeSize; i++) {
      suits.forEach(suit => {
        ranks.forEach(rank => {
          cards.push(new Card(rank, suit))
        })
      })
    };
    return _.shuffle(cards)
  }

  dealHand(handSize = 4) {
    let newHand = [];
    for (let i=0; i<handSize; i++) { newHand.push(this.cards.pop()); };
    return newHand;
  }
}

export default Deck;