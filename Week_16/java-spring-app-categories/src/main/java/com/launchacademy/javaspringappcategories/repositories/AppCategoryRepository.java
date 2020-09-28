package com.launchacademy.javaspringappcategories.repositories;

import com.launchacademy.javaspringappcategories.models.AppCategory;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AppCategoryRepository extends CrudRepository<AppCategory, Integer> {
  public AppCategory findByName(String name);
  public List<AppCategory> findAllByName(String name);
  public List<AppCategory> findByNameStartingWith(String namePrefix);
  public List<AppCategory> findByNameContaining(String nameSegment);
}
