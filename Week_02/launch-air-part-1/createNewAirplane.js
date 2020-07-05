/* 
Launch Academy
Assignment: Launch Air
Author: Tom Murphy
Last Edited: 2020-06-26 05:51 PT
*/

const createNewAirplane = (makeInput, modelInput, capacityInput) => {
  return {
    make: makeInput,
    model: modelInput,
    capacity: capacityInput,
    flights: [],
    scheduleFlight(flightInput) {
      this.flights.push(flightInput);
    },
    listDestinations() {
      let printDestinations = 'We will be flying to: \n';
      this.flights.forEach(flight => {
        printDestinations += `  ${flight.destination} \n`
      });
      console.log(printDestinations);
      console.log();
    }
  };
};

export default createNewAirplane;