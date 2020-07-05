/* 
Launch Academy
Assignment: JavaScript Objects Marathon
Author: Tom Murphy
Last Edited: 2020-07-03 20:07 PT
*/

const createNewRocket = (fuel = 0) => {
  let jsonNewRocket = {
      fuel,
      addFuel: (fueling) => {
        jsonNewRocket.fuel += fueling;
        console.log(`Fuel has been filled to ${jsonNewRocket.fuel} gallons.`);
      },
      fire: () => {
        if(jsonNewRocket.fuel > 0) {
          jsonNewRocket.fuel--;
          console.log(`The engines have been fired!\n` + 
                      `  Remaining fuel count: ${jsonNewRocket.fuel} gallons.\n`);
          return true;
        } else {
          console.log(`The engines failed to fire!\n` + 
                      `  Insufficient fuel.\n`);
          return false;
        };
      },
  };
  return jsonNewRocket;
};

// export our function so it can be imported in other files
export default createNewRocket;