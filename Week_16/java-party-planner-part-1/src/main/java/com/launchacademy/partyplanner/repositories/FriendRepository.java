package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Friend;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Integer> {
  boolean existsByFirstName(String firstName);
  boolean existsByLastName(String lastName);
  boolean existsByFirstNameAndLastName(String firstName, String lastName);
  public List<Friend> findAllByFirstName(String firstName);
  public Friend findFirstByFirstName(String firstName);
  public List<Friend> findAllByLastName(String lastName);
  public Friend findFirstByLastName(String lastName);
}
