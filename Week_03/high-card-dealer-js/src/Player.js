import Hand from './Hand.js'

class Player {
  constructor(name, hand = new Hand()) {
    this.name = name;
    this.hand = hand;
  };

  getName() {
    return this.name;
  };

  setName(name) {
    this.name = name;
  };
}

export default Player;