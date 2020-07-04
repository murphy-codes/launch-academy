/* 
Launch Academy
Assignment: JavaScript Objects Marathon
Author: Tom Murphy
Last Edited: 2020-07-03 20:07 PT
*/

import createNewSpaceship from './createNewSpaceship.js';
import createNewCrewMember from './createNewCrewMember.js';
import createNewRocket from './createNewRocket.js';

const crewNames = ["Ashley Kane", "Brendan Montima", "Cherish Kim", "Jeremy Sim", "John Bobst", "Jose Pineda", "Kara Ducasse", "Ria Mahoney", "Russ Moore", "Tom Murphy", "Dan Pickett", "Brianna Kincart", "Pat Whelan", "Dan Alberts"];

let trainCrew = arrayForCrewNames => arrayForCrewNames.map(function(strCrewName) { return createNewCrewMember(strCrewName, true);});

let ourShip = createNewSpaceship("Waverider");
let crewMembers = trainCrew(crewNames);
ourShip.loadCrew(crewMembers);
let vegaRocket = createNewRocket();

let launchpad = (ship) => {
    console.log("\nInitiating preflight procedures!\n");
    console.log(`Welcome aboard the ${ship.name}!\n`);
    //Announce the crew by using a for-of loop 
    for (let crewMember of ship.crew) {
      console.log(`${crewMember.name} is now aboard the Waverider. They're ${crewMember.trained ? '' : 'not '}trained.`);
    };
    console.log(`\nOur captain today is ${ship.captain()}! → *High Five*\n`);
    vegaRocket.addFuel(501369);
    ship.mountPropulsion(vegaRocket);
    ship.takeoff(10);
}

launchpad(ourShip);