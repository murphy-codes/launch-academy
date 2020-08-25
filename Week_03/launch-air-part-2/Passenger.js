import Ticket from './Ticket.js'

class Passenger {
  constructor(name, flights = []) {
    this.name = name;
    this.flights = flights;
  };
  
  purchaseTicket(flight, seat) {
    let ticket = new Ticket(flight, this.name, seat);
    this.flights.push(flight);
    return ticket;
  };
};

export default Passenger;