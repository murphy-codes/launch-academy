package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class FriendSeeder {
  @Autowired private FriendRepository friendRepository;
//  private FriendRepository friendRepository;
//
//  @Autowired
//  public FriendSeeder(FriendRepository friendRepository) { this.friendRepository = friendRepository; }

  public void seed() {
    Map<String, String> seedMap = new LinkedHashMap<>();
    seedMap.putAll(Map.of("Thomas","Ulsrud","Torger","Nergård","Christoffer","Svae","Håvard","Vad Petersson","Markus","Høiberg"));
    seedMap.putAll(Map.of("Kim","Chang-min","Seong","Se-hyeon","Oh","Eun-su","Lee","Ki-bok","Kym","Min-chan"));
    seedMap.putAll(Map.of("Niklas","Edin","Oskar","Eriksson","Rasmus","Wranå","Kristoffer","Sundgren","Henrik","Leek"));
    seedMap.putAll(Map.of("Benoît","Schwarz","Claudio","Pätz","Peter","de Cruz","Valentin","Tanner","Dominik","Märki"));
    seedMap.putAll(Map.of("John","Shuster","Tyler","George","Matt","Hamilton","Jon","Landsteiner","Joe","Polo"));
    for (String firstName: seedMap.keySet()) {
      if(!friendRepository.existsByFirstNameAndLastName(firstName,seedMap.get(firstName))) {
//      if(!friendRepository.existsByFirstName(firstName)) {
        Friend friend = new Friend();
        friend.setFirstName(firstName);
        friend.setLastName(seedMap.get(firstName));
        friendRepository.save(friend);
      }
    }
  }
}
