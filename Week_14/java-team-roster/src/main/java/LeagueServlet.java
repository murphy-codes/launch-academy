import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = "/")
public class LeagueServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    List<Team> teams = League.getLeague().getTeams();
    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/league.jsp");
    req.setAttribute("teams", teams);
    dispatcher.forward(req, res);
  }
}