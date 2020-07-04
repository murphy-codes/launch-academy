/* 
Launch Academy
Assignment: JavaScript Objects Marathon
Author: Tom Murphy
Last Edited: 2020-07-03 20:07 PT
*/

const createNewSpaceship = (name, crew = [], propulsion = null) => {
  let jsonNewShip = {
    name,
    crew,
    propulsion,
    loadCrew: (crewMembers) => {
        crewMembers.forEach(element => {jsonNewShip.crew.push(element);});
    },
    captain: () => {
      if (!!jsonNewShip.crew.length) {
        return jsonNewShip.crew[Math.floor(Math.random() * jsonNewShip.crew.length)].name;
      }
      return "nobody";
    },
    mountPropulsion: (propulsionSystem) => {
      jsonNewShip.propulsion = propulsionSystem;
      console.log("The propulsion system has been mounted!\n");
    },
    countdown: (timer) => {
      if (timer === 0) {
        console.log("We're blasting off!");
      } else {
        setTimeout(() => {
          console.log(`        ${timer}…`);
          timer--;
          jsonNewShip.countdown(timer);
        }, 1000);
      };
    },
    takeoff: (countdownTimer = 10) => {
      if (jsonNewShip.propulsion.fire()) {
        console.log(countdownTimer > 0 ? `T minus ${countdownTimer} seconds.` : ``);
        jsonNewShip.countdown(countdownTimer-1);
        console.log("Takeoff!");
        console.log("Random number of sh Sh SH RR Rr rr")
      } else {
        console.log("Takeoff was unsuccessful.");
      };
    }
  };
  return jsonNewShip;
};

// export our function so it can be imported in other files
export default createNewSpaceship;