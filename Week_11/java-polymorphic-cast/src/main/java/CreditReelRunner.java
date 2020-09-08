import java.util.ArrayList;

public class CreditReelRunner {
  public static void main(String[] args) {
    ArrayList<TeamMember> members = new ArrayList<TeamMember>();
    //Add team members here
    CastMember mollyParker = new CastMember("Molly", "Parker", "Maureen Robinson");
    CastMember tobyStephens = new CastMember("Toby", "Stephens", "John Robinson");
    CastMember maxwellJenkins = new CastMember("Maxwell", "Jenkins", "Will Robinson");
    Producer neilMarshall = new Producer("Neil", "Marshall");
    Producer zackEstrin = new Producer("Zack", "Estrin");
    members.add(mollyParker);
    members.add(tobyStephens);
    members.add(maxwellJenkins);
    members.add(neilMarshall);
    members.add(zackEstrin);

    for(TeamMember member : members) {
      //Output each team members credit line
      System.out.println(member.getCreditLine());
    }
  }
}
