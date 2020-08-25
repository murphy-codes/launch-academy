import Cage from './Cage.js';

class Zoo {
  constructor(name, numberOfCages = 10) {
    this.name = name;
    this.employees = [];
    this.cages = [];
    for (let i = 0; i < numberOfCages; i++) {
      this.cages.push(new Cage());
    };
  };

  addEmployee(employee) {
    this.employees.push(employee);
  };

  addAnimal(animal) {
    let theFirstEmptyCage = this.cages.find((cage) => {return cage.isEmpty();});
    if (theFirstEmptyCage) {
      theFirstEmptyCage.addAnimalIntoCage(animal);
    } else {
      return 'All of the cages are full!';
    };
  }

  visit() {
    let output = '';
    // iterate over the animals
    // add animal.speak() to the string
    // iterate over the employees
    // add employee.greet() to the string
    this.cages.forEach((cage) => {
      if (!cage.isEmpty()) {
        output += `${cage.animal.speak()}\n`;
      };
    });

    this.employees.forEach((employee) => {
      output += `${employee.greet()}\n`;
    });

    return output.slice(0,-1);
  }
}

export default Zoo