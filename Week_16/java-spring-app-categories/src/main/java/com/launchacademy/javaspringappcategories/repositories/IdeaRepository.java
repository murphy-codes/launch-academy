package com.launchacademy.javaspringappcategories.repositories;

import com.launchacademy.javaspringappcategories.models.Idea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IdeaRepository extends CrudRepository<Idea, Integer> {
  public List<Idea> findAll();
//  public Idea findById(Integer id);
  public Idea findByName(String name);
  public List<Idea> findAllByName(String name);
  public List<Idea> findByNameStartingWith(String namePrefix);
  public List<Idea> findByNameContaining(String nameSegment);
  public List<Idea> findByNameEndingWith(String namePrefix);
  public List<Idea> findByNameStartingWithIgnoreCase(String namePrefix);
//  public List<Idea> findByNameContainingNotLike(String nameSegment);

  @Query("SELECT i from Idea i where lower(i.name) like :namePrefix%")
  public List<Idea> whereNameStartsWith(@Param("namePrefix") String namePrefix);

}
