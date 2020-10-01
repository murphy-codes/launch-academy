package com.launchacademy.partyplanner.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired private PartySeeder partySeeder;
  @Autowired private FriendSeeder friendSeeder;
  @Autowired private AttendanceSeeder attendanceSeeder;

  @Override public void run(String... args) throws Exception {
    partySeeder.seed();
    friendSeeder.seed();
    attendanceSeeder.seed();
  }
}
