import Airplane from '../Airplane.js'

describe("airplane class", () => {
  let airplane;

  beforeEach(() => {
    airplane = new Airplane("Cesna", 10, 150, 75)
  });

  it("defines airplane", () => {
    expect(airplane).toBeInstanceOf(Airplane);
  });

  it("has an initialized type", () => {
    expect(airplane.type).toBe("Cesna");
  });

  it("has an initialized wing loading", () => {
    expect(airplane.wingLoading).toBe(10);
  });

  it("has an initialized horsepower", () => {
    expect(airplane.horsepower).toBe(150);
  });

  it("has an initialized fuel", () => {
    expect(airplane.fuel).toBe(75);
  });

  it("has an initialized engineRunning defaulted to 'false'", () => {
    expect(airplane.engineRunning).toBe(false);
  });

  it("has an initialized airborne defaulted to 'false'", () => {
    expect(airplane.airborne).toBe(false);
  });

  describe("#start", () => {
    it("returns 'airplane started' if the engine was off when called,\n" + 
      "          and sets the engingeRunning property = true", () => {
      expect(airplane.start()).toBe("airplane started");
      expect(airplane.engineRunning).toBe(true); // after
    });

    it("returns 'airplane already started' if the engine was already on", () => {
      airplane.start() // turns on the engine before we attempt to start while running
      expect(airplane.engineRunning).toBe(true); // after
      expect(airplane.start()).toBe("airplane already started");
    });

    it("returns 'not enough fuel to start' if out of fuel & engine was off", () => {
      airplane.fuel = 3;
      expect(airplane.start()).toBe("not enough fuel to start");
      expect(airplane.fuel).toBe(0); // after
    });

    it("returns 'the engine has run out of fuel' if out of fuel & engine was on,\n" + 
    "          and sets the engingeRunning property = false", () => {
      airplane.fuel = 7;
      airplane.start()
      expect(airplane.engineRunning).toBe(true); // after 1st call
      expect(airplane.fuel).toBe(2); // after 1st call
      expect(airplane.start()).toBe("the engine has run out of fuel");
    });
  });

  describe("#takeoff", () => {
    it("returns 'airplane not started, please start' if engine was off", () => {
      expect(airplane.takeOff()).toBe("airplane not started, please start");
      expect(airplane.fuel).toBe(72); // after
    });

    it("returns 'airplane launched' if the engine was already on", () => {
      airplane.start() // turns on the engine before we attempt to takeoff
      expect(airplane.takeOff()).toBe("airplane launched");
      expect(airplane.airborne).toBe(true); // after
      expect(airplane.fuel).toBe(20); // after
    });

    it("returns 'the engine has run out of fuel' if fuel is insufficient", () => {
      airplane.fuel = 10;
      airplane.engineRunning = true;
      expect(airplane.takeOff()).toBe("the engine has run out of fuel");

      airplane.fuel = 2;
      expect(airplane.takeOff()).toBe("the engine has run out of fuel");
    });
  });

  describe("#land", () => {
    it("returns 'airplane not started, please start' if engine was off", () => {
      expect(airplane.land()).toBe("airplane not started, please start");
      expect(airplane.fuel).toBe(72); // after
    });

    it("returns 'airplane already on the ground' if not airborne", () => {
      airplane.start() // turns on the engine before we attempt to land
      expect(airplane.land()).toBe("airplane already on the ground");
      expect(airplane.fuel).toBe(69); // after
    });

    it("returns 'airplane landed' if airplane was airborne", () => {
      airplane.start() // turns on the engine before we attempt to land
      airplane.takeOff() // takes off to set the plane airborne
      expect(airplane.land()).toBe("airplane landed");
      expect(airplane.airborne).toBe(false); // after
      expect(airplane.fuel).toBe(5); // after
    });

    it("returns 'the engine has run out of fuel' if fuel is insufficient", () => {
      airplane.fuel = 10;
      airplane.engineRunning = true;
      airplane.airborne = true;
      expect(airplane.land()).toBe("the engine has run out of fuel, initiating emergency landing");

      airplane.fuel = 0.5;
      airplane.engineRunning = true;
      expect(airplane.land()).toBe("the engine has run out of fuel");

      airplane.fuel = 2;
      expect(airplane.land()).toBe("the engine has run out of fuel");
    });
  });

  describe("#sufficientFuel", () => {
    beforeEach(() => {
      airplane.fuel = 50;
    });

    it("returns 'true' if the fuel tank has enough fuel", () => {
      expect(airplane.fuel).toBe(50);
      expect(airplane.sufficientFuel(50)).toBe(true);
      expect(airplane.sufficientFuel(40)).toBe(true);
    });

    it("returns 'false' if the fuel tank doesn't have enough fuel", () => {
      expect(airplane.fuel).toBe(50);
      expect(airplane.sufficientFuel(60)).toBe(false);
    });
  });

  describe("#goDry", () => {
    beforeEach(() => {
      airplane.fuel = 50;
      airplane.engineRunning = true;
      airplane.airborne = true;
    });

    it("returns 'the engine has run out of fuel' and !s fuel, engineR, & airborne", () => {
      expect(airplane.goDry()).toBe("the engine has run out of fuel");
      expect(airplane.fuel).toBe(0);
      expect(airplane.engineRunning).toBe(false);
      expect(airplane.airborne).toBe(false);
    });
  });
})