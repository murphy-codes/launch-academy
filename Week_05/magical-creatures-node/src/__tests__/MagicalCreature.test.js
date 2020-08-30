import MagicalCreature from '../MagicalCreature.js'
import creatures from '../creatures.js'

describe("magicalCreature class", () => {
  let magicalCreature;

  const bearPigs = [
    {
      "name": "Elder ManBearPig",
      "ability": "half man, half bear, half pig, all ancient",
      "age": 879
    }, {
      "name": "ManBearPig",
      "ability": "half man, half bear, half pig",
      "age": 79
    }, {
      "name": "BabyBearPig",
      "ability": "half baby, half bear, half pig, much cute",
      "age": 7
    }
  ];

  beforeEach(() => {
    magicalCreature = new MagicalCreature(bearPigs[1]);
  });

  it("defines magical creature", () => {
    expect(magicalCreature).toBeInstanceOf(MagicalCreature);
  });

  it("has an initialized name", () => {
    expect(magicalCreature.name).toBe("ManBearPig");
  });

  it("has an initialized ability", () => {
    expect(magicalCreature.ability).toBe("half man, half bear, half pig");
  });

  it("has an initialized age", () => {
    expect(magicalCreature.age).toBe(79);
  });

  it("can have an initialized extra attribute", () => {
    let powerfulCreature = new MagicalCreature(
      {"name": "Saiyan", "ability": "can eat rice and train well", "age": 24, "powerLevel": "Over 9,000!"});
    expect(powerfulCreature.powerLevel).toBe("Over 9,000!");
  });

  describe("#isAncient", () => {
    let ancientMagicalCreature;

    beforeEach(() => {
      ancientMagicalCreature = new MagicalCreature(bearPigs[0]);
    });

    it("returns 'true' if the creature is 'ancient'.", () => {
      expect(ancientMagicalCreature.isAncient()).toBe(true);
    });

    it("returns 'false' if the creature is not 'ancient'.", () => {
      expect(magicalCreature.isAncient()).toBe(false);
    });
  });

  describe("#findAll", () => {
    it("returns 'null' if not given an array.", () => {
      expect(MagicalCreature.findAll("Werewolf")).toBe(null);
    });

    it("returns an array of default creatures if given no arguments.", () => {
      const expected = MagicalCreature.findAll(creatures);
      const defaultFindAll = MagicalCreature.findAll();
      expect(defaultFindAll).toBeInstanceOf(Array);
      expect(defaultFindAll).toEqual(expect.arrayContaining(expected));
      expect(defaultFindAll[0].name).toBe(creatures[0].name); // "Unicorn" === "Unicorn"
    });

    it("returns an array of custom creatures if supplied.", () => {
      const expected = bearPigs.map((creature) => { return new MagicalCreature(creature);});
      const customFindAll = MagicalCreature.findAll(bearPigs);
      expect(customFindAll).toBeInstanceOf(Array);
      expect(customFindAll).toEqual(expect.arrayContaining(expected));
      expect(customFindAll[2].name).toBe(bearPigs[2].name); // "BabyBearPig" === "BabyBearPig"
    });
  });

  describe("#find", () => {
    it("returns 'undefined' if not given a value.", () => {
      expect(MagicalCreature.find()).toBe(undefined);
    });
    
    it("returns 'undefined' if optional value supplied isn't an array.", () => {
      expect(MagicalCreature.find("Alien", 4)).toBe(undefined);
    });
    
    it("returns 'undefined' if supplied optional array's values don't have name keys.", () => {
      expect(MagicalCreature.find("Alien", [{"n": 4},{"a" : 1}])).toBe(undefined);
    });

    it("returns 'undefined' name doesn't matching a known creature.", () => {
      expect(MagicalCreature.find("Werewolf")).toBe(undefined);
      expect(MagicalCreature.find("Zombie", bearPigs)).toBe(undefined);
    });
    
    it("returns the creature if the name matches a (default) creature.", () => {
      const defaultFind = MagicalCreature.find("Unicorn");
      expect(defaultFind).toBeInstanceOf(MagicalCreature);
      expect(defaultFind.age).toBe(140);
    });
    
    it("returns the creature if the name matches a (custom) creature.", () => {
      const customFind = MagicalCreature.find("ManBearPig", bearPigs);
      expect(customFind).toBeInstanceOf(MagicalCreature);
      expect(customFind.age).toBe(79);
    });
  });
});