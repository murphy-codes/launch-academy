class Airplane{
  constructor(type, wingLoading, horsepower, fuel = 0) {
    this.type = type;
    this.wingLoading = wingLoading;
    this.horsepower = horsepower;
    this.fuel = fuel;
    this.engineRunning = false;
    this.airborne = false;
  };

  start() {
    if(!this.sufficientFuel(5)) {
      this.fuel = 0;
      if (this.engineRunning) {
        return this.goDry();
      } else {
        return "not enough fuel to start";
      };
    };
    this.fuel -= 5;
    if (this.engineRunning) {
      return "airplane already started";
    };
    this.engineRunning = true;
    return "airplane started";
  };

  takeOff() {
    if (this.engineRunning) {
      if(!this.sufficientFuel(50)) {
        return this.goDry();
      } else {
        this.fuel -= 50;
        this.airborne = true;
        return "airplane launched";
      };
    } else if (!this.sufficientFuel(3)) {
      return this.goDry();
    };
    this.fuel -= 3;
    return "airplane not started, please start";
  };

  land() {
    if (!this.engineRunning) {
      if(!this.sufficientFuel(3)) {
        return this.goDry();
      } else {
        this.fuel -= 3;
        return "airplane not started, please start";
      };
    } else if (!this.airborne) {
      if(!this.sufficientFuel(1)) {
        return this.goDry();
      } else {
        this.fuel--;
        return "airplane already on the ground";
      };
    };
    if(!this.sufficientFuel(15)) {
      return this.goDry()+", initiating emergency landing";
    } else {
      this.fuel -= 15;
      this.airborne = false;
      return "airplane landed";
    };
  };

  sufficientFuel(requiredFuel) {
    return this.fuel >= requiredFuel ? true : false;
  };

  goDry() {
    this.fuel = 0
    this.engineRunning = false;
    this.airborne = false;
    return "the engine has run out of fuel";
  };
};

export default Airplane