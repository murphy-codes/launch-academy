package com.launchacademy.launchrpg.repositories;

import com.launchacademy.launchrpg.models.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends CrudRepository<School, Integer> {
}
