class Pool {
  constructor(width, length = width) {
    this.width = width;
    this.length = length;
  };
  
  area() {
    return this.width * this.length;
  };
  
  volume() {
    return this.area() * 5;
  };
};

export default Pool;