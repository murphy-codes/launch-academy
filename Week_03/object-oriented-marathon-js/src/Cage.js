class Cage {
  constructor(animal = null) {
    this.animal = animal;
  };

  isEmpty() {
    return !this.animal;
  };

  addAnimalIntoCage(animal) {
    this.animal = animal;
  };
};

export default Cage;