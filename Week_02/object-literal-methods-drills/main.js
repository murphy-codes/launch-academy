let guybrushThreepwood = {
  firstName: 'Guybrush',
  lastName: 'Threepwood',
  title: 'flooring inspector',
  lungCapacityMinutes: 10,
  breathHeldMinutes: 0, 
  gameOver: false,
  inventory: ["stuff","things"],
  haveGrog: false,
  setTitle: (newTitle) => {
    guybrushThreepwood.title = newTitle;
  },
  greet: () => {
    console.log(`I'm ${guybrushThreepwood.firstName} ` + 
      `${guybrushThreepwood.lastName}, ${guybrushThreepwood.title}.`);
  },
  holdBreath: () => {
    guybrushThreepwood.breathHeldMinutes ++;
    if(guybrushThreepwood.breathHeldMinutes >= guybrushThreepwood.lungCapacityMinutes) {
      guybrushThreepwood.gameOver = true;
      console.log(`Sorry! ${guybrushThreepwood.firstName} ${guybrushThreepwood.lastName} ` + 
        `can only hold his breath for ${guybrushThreepwood.lungCapacityMinutes} ` + 
        `minutes \nand he's been down there for ${guybrushThreepwood.breathHeldMinutes} ` + 
        `minutes → Game Over!`);
    };
  },
  addToInventory: (item) => {
    if(!guybrushThreepwood.inventory.includes(item)){
      guybrushThreepwood.inventory.push(item);
    };
  },
  checkGrogStatus: () => {
    if(guybrushThreepwood.inventory.includes("red dye #2") && guybrushThreepwood.inventory.includes("battery acid")) {
      console.log("Makin' some grog!");
      guybrushThreepwood.haveGrog = true;
    } else {
      console.log("Where has all the grog gone?");
    }
  }
};

console.log(guybrushThreepwood, "\n");
guybrushThreepwood.greet();
guybrushThreepwood.setTitle('mighty pirate');
guybrushThreepwood.greet();
console.log();
for(i=0; i<10; i++) {
  guybrushThreepwood.holdBreath();
};
console.log();
guybrushThreepwood.addToInventory("red dye #2");
guybrushThreepwood.checkGrogStatus();
guybrushThreepwood.addToInventory("battery acid");
guybrushThreepwood.checkGrogStatus();