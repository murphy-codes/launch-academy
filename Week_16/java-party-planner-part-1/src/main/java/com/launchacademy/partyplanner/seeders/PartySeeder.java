package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PartySeeder {
  @Autowired private PartyRepository partyRepository;
//  private PartyRepository partyRepository;
//
//  @Autowired
//  public PartySeeder(PartyRepository partyRepository) { this.partyRepository = partyRepository; }

  public void seed() {
    List<String> nameList = Arrays.asList("Carl Sagan Birthday","Surprise Timmy Party","Lord of the Rings Marathon","CatCon","Launch Graduation");
    List<String> descriptionList = Arrays.asList("Small and socially distanced bbq","Timmy is back from bootcamp","One does not simply walk to Mordor","It is time to celebrate our feline friends!","Virtual drinks and relaxation");
    List<String> locationList = Arrays.asList("The park down the street","Pizza Palace","My tiny living room","Online","Zoom");
    for (int i = 0; i < 5; i++) {
      if(!partyRepository.existsByName(nameList.get(i))) {
        Party party = new Party();
        party.setName(nameList.get(i));
        party.setDescription(descriptionList.get(i));
        party.setLocation(locationList.get(i));
        partyRepository.save(party);
      }
    }
  }
}
