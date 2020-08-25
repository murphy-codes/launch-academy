class Airplane {
  constructor(make, model, capacity, flights = []) {
    this.make = make;
    this.model = model;
    this.capacity = capacity;
    this.flights = flights;
  };
  
  scheduleFlight(flight) {
    this.flights.push(flight);
  };
};

export default Airplane;