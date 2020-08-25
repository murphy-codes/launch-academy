class Conference {
  constructor(name, maxRegistrants, attendees = [], sessions = []) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = attendees;
    this.sessions = sessions;
  };

  register(person) {
    if (this.attendees.length < this.maxRegistrants && 
      !this.attendees.some(attendee => attendee.email === person.email)) {
      this.attendees.push(person);
      return true;
    };
    return false;
  };

  addSession(session) {
    if (this.attendees.some(attendee => attendee.email === session.facilitator.email)){
      this.sessions.push(session);
      return true;
    }
    return false;
  };

  summary() {
    let pamphlet = `Conference name: ${this.name}\n` + 
                  `Number of registrants: ${this.attendees.length}`;
    this.attendees.forEach(attendee => {
      pamphlet += `\n  ${attendee.firstName} ${attendee.lastName}`;
    });
    pamphlet += `\nNumber of sessions: ${this.sessions.length}`;
    this.sessions.forEach(session => {
      pamphlet += `\n  Title: ${session.title}\n  Facilitator: ${session.facilitator}`;
    });
    pamphlet += `\nRegistration is ${(this.attendees.length < this.maxRegistrants) ? `open (${this.maxRegistrants - this.attendees} seats remaining)`: `closed`}`;
    // if (this.attendees.length < this.maxRegistrants) {
    //   //
    // };
    return pamphlet;
  };
};

export default Conference;