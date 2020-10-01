package com.launchacademy.teamrosterwithspring.repositories;

import com.launchacademy.teamrosterwithspring.models.Position;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PositionRepository extends CrudRepository<Position, Integer> {
  public List<Position> findAllByPositionName(String name);
  public Position findFirstByPositionName(String name);
}