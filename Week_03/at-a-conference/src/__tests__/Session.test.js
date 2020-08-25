import Session from '../Session.js';
import Person from '../Person.js';

describe("session class", () => {
  let person;
  let session;

  beforeEach(() => {
    person = new Person("Sam", "Seaborn", "sam.seaborn@example.com");
    session = new Session("30-min Introduction", person, "07:30", "08:00");
  });

  it("defines session", () => {
    expect(session).toBeInstanceOf(Session);
  });

  it("has an initialized title", () => {
    expect(session.title).toBe("30-min Introduction");
  });

  it("has an initialized facilitator", () => {
    expect(session.facilitator).toBe(person);
  });
})