package com.launchacademy.games;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GameService {
  private EntityManager em;

  public GameService(EntityManager em) {
    this.em = em;
  }

  public Boolean save(Game game) {
    // save the game to the database
    try {
      // return true if successful
      em.getTransaction().begin();
      em.persist(game);
      em.getTransaction().commit();
      return true;
    }
    catch(Exception e) {
      // return false if it's not
      System.out.println("Failed to persist");
      return false;
    }
  }

  public List<Game> getGames() {
    TypedQuery<Game> query = em.createQuery("SELECT g from Game g", Game.class);
    return query.getResultList();
  }
}

// Migration
// Entity
// Controller - doGet for a form, JSP form page
// Controller - doPost for a form (save to a database with EntityManagers)
// Controller - doGet for an index page, JSP index page
