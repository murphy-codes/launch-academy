class Hand {
  constructor(cards = []) {
    this.cards = cards;
  };

  getValue() {
    let valueOfHand = 0;
    this.cards.forEach(card => { valueOfHand+=card.value; });
    return valueOfHand;
  };

  showHand() {
    let faceUp = "";
    this.cards.forEach(card => { faceUp += `${card.rank}${card.suit}, `; });
    return faceUp.slice(0, faceUp.length-2);
  };
}

export default Hand;