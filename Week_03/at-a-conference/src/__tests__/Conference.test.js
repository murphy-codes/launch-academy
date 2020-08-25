import Conference from '../Conference.js';
import Session from '../Session.js';
import Person from '../Person.js';

describe("conference class", () => {
  let conference;

  beforeEach(() => {
    conference = new Conference("Launch Academy Hackathon", 2);
  });

  it("defines conference", () => {
    expect(conference).toBeInstanceOf(Conference);
  });

  it("has an initialized name", () => {
    expect(conference.name).toBe("Launch Academy Hackathon");
  });

  it("has an initialized maximum number of registrants", () => {
    expect(conference.maxRegistrants).toBe(2);
  });

  it("has an initialized blank list of attendees", () => {
    expect(conference.attendees).toEqual([]);
    // expect(conference.attendees).toBe([]);
    // expect(Array.isArray(conference.attendees)).toBe(true);
  });

  it("has an initialized blank list of sessions", () => {
    expect(conference.sessions).toEqual([]);
    // expect(conference.sessions).toBe([]);
    // expect(Array.isArray(conference.sessions)).toBe(true);
  });

  describe("#register", () => {
    let personSam;
    let personSally;
    let personJack;

    beforeEach(() => {
      personSam = new Person("Sam", "Seaborn", "sam.seaborn@example.com");
      personSally = new Person("Sally", "Seaborn", "sally.seaborn@example.com");
      personJack = new Person("Jack", "Skellington", "pumpkin.king@halloweentown.com");
    });

    it("returns 'true' if the supplied person object successfully registered", () => {
      expect(conference.register(personSam)).toBe(true);
    });

    it("returns 'false' if the supplied person's email is already registered'", () => {
      conference.register(personSally);
      expect(conference.register(personSally)).toBe(false);
    });

    it("returns 'false' if the conference is at max capacity'", () => {
      conference.register(personSam);
      conference.register(personSally);
      expect(conference.register(personJack)).toBe(false);
    });
  });

  describe("#addSession", () => {
    let person;
    let session;
    
    beforeEach(() => {
      person = new Person("Sam", "Seaborn", "sam.seaborn@example.com");
      session = new Session("30-min Introduction", person, "07:30", "08:00");
    });

    it("returns 'true' if the session facilitator is a registered attendee", () => {
      conference.register(person);
      expect(conference.addSession(session)).toBe(true);
    });

    it("returns 'false' if the session facilitator isn't a registered attendee'", () => {
      expect(conference.addSession(session)).toBe(false);
    });
  });
});
