package com.launchacademy.games;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/games/new", "/games", "/games/"})
public class GamesController extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    RequestDispatcher dispatcher;
    // check for the proper path
    if(req.getServletPath().equals("/games/new")) {
      // render the form at "/games/new"
      dispatcher = req.getRequestDispatcher("/views/games/form.jsp");
    }
    else {
      dispatcher = req.getRequestDispatcher("/views/games/index.jsp");
//      req.setAttribute("games", GameService(getEmf().createEntityManager()).getGames());
      GameService service = new GameService(getEmf().createEntityManager());
      req.setAttribute("games", service.getGames());
    }
    dispatcher.forward(req, res);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // check for the proper path
    if(req.getServletPath().equals("/games")) {
      // make an empty com.launchacademy.games.Game
      Game newGame = new Game();

      // fill it with the user's input
      try {
        BeanUtils.populate(newGame, req.getParameterMap());
      }
      catch(IllegalAccessException ex){ ex.printStackTrace(); } // System.out.println("ERROR:\nBeanUtils could not find setter: ");
      catch(InvocationTargetException ex) { System.out.println(ex); } // System.out.println("ERROR:\nBeanUtils had an error with the setter: ");

      // try to save it to the database
//      EntityManagerFactory emf = getEmf();
//      EntityManager em = emf.createEntityManager();
      EntityManager em = getEmf().createEntityManager();

      GameService service = new GameService(em);
      service.save(newGame);

      em.close();

      // redirect somewhere once it's done
      res.sendRedirect("/games/new");
    }
    else {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }

}
