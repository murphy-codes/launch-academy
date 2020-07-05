/* 
Launch Academy
Assignment: Launch Air
Author: Tom Murphy
Last Edited: 2020-06-26 05:51 PT
*/

const createNewFlight = (dateInput, takeoffTimeInput, landingTimeInput, originInput, destinationInput) => {
  return {
    date: dateInput,
    takeoffTime: takeoffTimeInput,
    landingTime: landingTimeInput,
    origin: originInput,
    destination: destinationInput,
    flightDestination() {
      if (this.destination === 'New York, NY') {
        console.log('Welcome to the Big Apple!');
      } else if (this.destination === 'San Diego, CA') {
        console.log(`Welcome to sunny ${this.destination}.`);
      } else if (this.destination === 'Boston, MA') {
        console.log(`Welcome to beautiful ${this.destination}.`);
      } else {
        console.log(`We have arrived at ${this.destination}. \nThank you for flying with us.`);
      };
      console.log();
    }
  };
};

export default createNewFlight;