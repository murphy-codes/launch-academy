class Card {
  constructor(rank, suit) {
    this.rank = rank;
    this.suit = suit;
    this.value = this.setValue();
  };

  setValue() {
    let faceCards = {"J": 11, "Q": 12, "K": 13, "A": 14};
    return this.rank in faceCards ? faceCards[this.rank] : this.rank;
  };

  getValue() {
    return this.value;
  }
};

export default Card;