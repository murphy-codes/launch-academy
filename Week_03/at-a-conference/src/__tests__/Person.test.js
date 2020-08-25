import Person from '../Person.js';

describe("person class", () => {
  let person;

  beforeEach(() => {
    person = new Person("Sam", "Seaborn", "sam.seaborn@example.com");
  });

  it("defines person", () => {
    expect(person).toBeInstanceOf(Person);
  });

  it("has an initialized firt name", () => {
    expect(person.firstName).toBe("Sam");
  });

  it("has an initialized last name", () => {
    expect(person.lastName).toBe("Seaborn");
  });

  it("has an initialized email", () => {
    expect(person.email).toBe("sam.seaborn@example.com");
  });
})