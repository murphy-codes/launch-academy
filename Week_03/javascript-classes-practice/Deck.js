class Deck {
  constructor(cards = []) {
    this.cards = cards;
  };

  addCard(card) {
    this.cards.push(card);
  };
};

export default Deck;