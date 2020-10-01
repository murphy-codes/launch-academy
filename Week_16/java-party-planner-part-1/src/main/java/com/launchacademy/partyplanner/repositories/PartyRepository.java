package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Party;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PartyRepository extends CrudRepository<Party, Integer> {
  boolean existsByName(String name);
  public List<Party> findAllByName(String name);
  public Party findFirstByName(String name);
}
