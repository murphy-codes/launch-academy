import creatures from './creatures.js'

class MagicalCreature {
  constructor(json) {
    for (let key of Object.keys(json)) this[key] = json[key];
  };
  
  isAncient() {
    return this.age === null || this.age > 200 ? true : false;
  };

  static findAll(critters = creatures) {
    return (Array.isArray(critters)) ? critters.map((creature) => { return new MagicalCreature(creature); }) : null;
  };

  static find(creatureName, listOfCreatures = creatures) {
    let critter;
    if (Array.isArray(listOfCreatures) && listOfCreatures.every(creature => creature.hasOwnProperty('name'))) { critter = listOfCreatures.find(creature => creature.name === creatureName); };
    if (critter) { return new MagicalCreature(listOfCreatures.find(creature => creature.name === creatureName)); };
  };
};

export default MagicalCreature;