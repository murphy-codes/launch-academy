class Snake {
  constructor(name, coldBlooded = true) {
    this.name = name;
    this.coldBlooded = coldBlooded;
  };
  speak() {
    return 'Sssssire, ssssire, they may be banditsssss';
  };
  isColdBlooded() {
    return this.coldBlooded;
  };
};

export default Snake; // pronounced Snek