/* 
Launch Academy
Assignment: Launch Air
Author: Tom Murphy
Last Edited: 2020-06-26 05:51 PT
*/

import createNewAirplane from './createNewAirplane.js'
import createNewFlight from './createNewFlight.js'

let magic747 = createNewAirplane('Boeing', '737', 215);

let maidenFlight = createNewFlight('Fri 2020/07/03','04:30 AM PT','12:52 PM ET', 'San Francisco, CA', 'New York, NY'); // AA 234
let secondFlight = createNewFlight('Fri 2020/07/03','01:30 PM ET','02:45 PM ET', 'New York, NY', 'Boston, MA'); // AA 3407
let thirdFlight = createNewFlight('Fri 2020/07/03','03:20 PM ET','12:12 AM PT', 'Boston, MA', 'San Diego, CA'); // AA 116, 1 Stop
let fourthFlight = createNewFlight('Sat 2020/07/04','01:00 AM PT','04:28 AM PT', 'San Diego, CA', 'San Francisco, CA'); // AA 2037, 1 Stop

magic747.scheduleFlight(maidenFlight);
magic747.scheduleFlight(secondFlight);
magic747.scheduleFlight(thirdFlight);
magic747.scheduleFlight(fourthFlight);
//console.log(magic747);
magic747.listDestinations();
maidenFlight.flightDestination();
secondFlight.flightDestination();
thirdFlight.flightDestination();
fourthFlight.flightDestination();