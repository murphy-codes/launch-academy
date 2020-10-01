package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Attendance;
import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.AttendanceRepository;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttendanceSeeder {
  @Autowired private AttendanceRepository attendanceRepository;
  @Autowired private FriendRepository friendRepository;
  @Autowired private PartyRepository partyRepository;
//  private AttendanceRepository attendanceRepository;
//  private FriendRepository friendRepository;
//  private PartyRepository partyRepository;
//
//  @Autowired
//  public AttendanceSeeder(AttendanceRepository attendanceRepository, FriendRepository friendRepository, PartyRepository partyRepository) {
//    this.attendanceRepository = attendanceRepository;
//    this.friendRepository = friendRepository;
//    this.partyRepository = partyRepository;
//  }

  public void seed() {
    if(((List<Attendance>) attendanceRepository.findAll()).size() == 0) {
      List<Friend> friends = (List<Friend>) friendRepository.findAll();
      List<Party> parties = (List<Party>) partyRepository.findAll();
      int j, partyNum;
      j = partyNum = 0;
      for (int i = 0; i < 25; i++) {
        Attendance attendance = new Attendance();
        attendance.setParty(parties.get(partyNum));
        attendance.setFriend(friends.get(i));
        attendanceRepository.save(attendance);
        if (++j == 5) {
          j = 0;
          partyNum++;
        }
      }
    }
  }
}
