package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, Integer> {
}
