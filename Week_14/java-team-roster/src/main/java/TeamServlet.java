import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = "/team")
public class TeamServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    RequestDispatcher dispatcher;
    try {
      Team team = League.getLeague().getTeams().get(Integer.parseInt(req.getParameter("teamIndex")));
      dispatcher = req.getRequestDispatcher("/views/team.jsp");
      req.setAttribute("teamName", team.getTeamName());
      req.setAttribute("players", team.getPlayers());
    } catch (Exception e) {
      dispatcher = req.getRequestDispatcher("/views/404.jsp");
    }
    dispatcher.forward(req, res);
  }
}