package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.Archetype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchetypeRepository extends CrudRepository<Archetype, Integer> {
}
