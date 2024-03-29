package com.launchacademy.javaspringappcategories.repositories;

import com.launchacademy.javaspringappcategories.models.Idea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IdeaRepository extends CrudRepository<Idea, Integer> {
  public Idea findByName(String name);
  public List<Idea> findAllByName(String name);
  public List<Idea> findByNameStartingWith(String namePrefix);
  public List<Idea> findByNameContaining(String nameSegment);
  public List<Idea> findByNameEndingWith(String namePrefix);
  public List<Idea> findByNameStartingWithIgnoreCase(String namePrefix);
  public Idea findFirstByDescriptionNotContaining(String nameSegment);
  public Idea findFirstByNameNotContainingAndDescriptionNotContaining(String nameSegment, String descriptionSegment);
  public Idea findFirstByNameNotLikeAndDescriptionNotLike(String nameSegment, String descriptionSegment);

  @Query("SELECT i from Idea i where lower(i.name) like lower(concat('%', :namePrefix,'%'))")
  public List<Idea> whereNameStartsWith(@Param("namePrefix") String namePrefix);

  @Query("SELECT i from Idea i where lower(i.name) not like lower(concat('%',:segment,'%')) and lower(i.description) not like lower(concat('%',:segment,'%'))")
  public List<Idea> whereNotContaining(@Param("segment") String segment);
}
