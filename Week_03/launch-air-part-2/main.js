/* 
Launch Academy
Assignment: Launch Air Part 2
Author: Tom Murphy
Last Edited: 2020-07-01 09:56 PT
*/

import Airplane from './Airplane.js'
import Flight from './Flight.js'
import Passenger from './Passenger.js'

let magic737 = new Airplane('Boeing', '737', 215);

let maidenFlight = new Flight('Fri 2020/07/03','04:30 AM PT','12:52 PM ET', 'San Francisco, CA', 'New York, NY'); // AA 234
let secondFlight = new Flight('Fri 2020/07/03','01:30 PM ET','02:45 PM ET', 'New York, NY', 'Boston, MA'); // AA 3407
let thirdFlight = new Flight('Fri 2020/07/03','03:20 PM ET','12:12 AM PT', 'Boston, MA', 'San Diego, CA'); // AA 116, 1 Stop
let fourthFlight = new Flight('Sat 2020/07/04','01:00 AM PT','04:28 AM PT', 'San Diego, CA', 'San Francisco, CA'); // AA 2037, 1 Stop

let mrTaco = new Passenger('Mr. Taco');
let msMonkey = new Passenger('Ms. Monkey');
let tacoTicket = mrTaco.purchaseTicket(maidenFlight, 'cabin kitchen seat')
let tacoTicket2 = mrTaco.purchaseTicket(secondFlight, 'cabin kitchen seat')
let monkeyTicket = msMonkey.purchaseTicket(secondFlight, 'emergency exit seat B')

magic737.scheduleFlight(maidenFlight);
magic737.scheduleFlight(secondFlight);
magic737.scheduleFlight(thirdFlight);
magic737.scheduleFlight(fourthFlight);

console.log(tacoTicket);
console.log(tacoTicket2);
console.log(monkeyTicket);
console.log(mrTaco.flights);
console.log(msMonkey.flights);
console.log(magic737);