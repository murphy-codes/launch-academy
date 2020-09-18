import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/games/new","/games"})
public class GameController extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // check for the proper path
    if (req.getServletPath().equals("/games/new")) {
      //render the form at "/games/new"
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/form.jsp");
      dispatcher.forward(req, res);
    }
    else {
      res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // check for the proper path
    if (req.getServletPath().equals("/games")) {
      Game game = new Game();

      // fill it with the user's input
      try {
        BeanUtils.populate(game, req.getParameterMap());
      }
      catch (IllegalAccessException e) {
        System.out.println("E");
        System.out.println("ERROR:\nBeanUtils could not find setter: " + e);
        e.printStackTrace();
      }
      catch (InvocationTargetException e) {
        System.out.println("E");
        System.out.println("ERROR:\nBeanUtils had an error with the setter: " + e);
        e.printStackTrace();
      }



//      // try to save it to the database
      EntityManagerFactory emf = getEmf();
      EntityManager em = emf.createEntityManager();

      GameService service = new GameService(em);
      service.save(game);

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
