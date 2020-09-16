import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/games/new"})
public class GameController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
}
