//package com.launchacadamy.games;

import javax.persistence.EntityManager;

public class GameService {
  private EntityManager em;

  public GameService(EntityManager em) { this.em = em; }

  public Boolean save(Game game) {
    // try to save it to the database
    try {
      // return true if successful
      em.getTransaction().begin();
      em.persist(game);
      em.getTransaction().commit();
      return true;
    }
    catch (Exception e) {
      // return false if it's not
      System.out.println("Failed to persist");
      e.printStackTrace();
      return false;
    }
  }
}
