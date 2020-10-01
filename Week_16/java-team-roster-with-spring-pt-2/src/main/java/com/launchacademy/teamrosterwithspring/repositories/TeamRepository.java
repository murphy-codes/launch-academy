package com.launchacademy.teamrosterwithspring.repositories;

import com.launchacademy.teamrosterwithspring.models.Team;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {
  public List<Team> findAllByTeamName(String name);
}