import java.util.ArrayList;

public class Conference {
  private String name;
  private int maxRegistrants;
  private ArrayList<Person> attendees;
  private ArrayList<Session> sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<>();
    this.sessions = new ArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public ArrayList getAttendees(){
    return this.attendees;
  }

  public ArrayList getSessions(){
    return this.sessions;
  }

  public boolean isOpen(){ return this.attendees.size() < this.maxRegistrants; }

  public boolean register(Person newAttendee){
    ArrayList<String> attendeeEmails = new ArrayList<>();
    for (Person attendee : this.attendees) {
      attendeeEmails.add(attendee.getEmail());
    }
    if (attendeeEmails.contains(newAttendee.getEmail()) || !isOpen()) {  return false; }
    else {
      this.attendees.add(newAttendee);
      return true;
    }
  }

  public boolean addSession(Session session) {
    this.sessions.add(session);
    return true;
  }

  public String getSummary() {
    String output = "Welcome to the \"" + getName() + "\" Conference";
    output += "\nNumber of Attendees: " + this.attendees.size() + "/" + getMaxRegistrants();
    for(Person person : this.attendees) {
      output += "\n  " + person.getName();
    }
    output += "\nNumber of Sessions: " + this.sessions.size();
    for(Session session : this.sessions) {
      output += "\n  \"" + session.getName() + "\", facilitated by: " + session.getFacilitator().getName();
    }
    if (isOpen()) { output += "\nRegistration is still open.\n"; }
    else { output += "\nRegistration is now closed.\n"; }
    return output;
  }
}
