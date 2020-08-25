class Plane {
  constructor(make, model, capacity, passengerCount = 0) {
    this.make = make;
    this.model = model;
    this.capacity = capacity;
    this.passengerCount = passengerCount;
  };

  board() {
    if (this.passengerCount < this.capacity) {
      this.passengerCount++;
      console.log(`The plane has ${this.passengerCount} passengers of an allowed ${this.capacity}.`);
    } else {
      console.log("This plane is at capacity!");
    };
  };
};

export default Plane;