import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/position", "/positions"})
public class PositionServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    RequestDispatcher dispatcher;
    List<Team> teams = League.getLeague().getTeams();
    List<String> positions = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    boolean getPlayers = req.getServletPath().equals("/position");
    String position = req.getParameter("name");
    for (Team team: teams) { for (Player player: team.getPlayers()) {
      if (!positions.contains(player.getPosition())) { positions.add(player.getPosition()); }
      if (getPlayers) { if (player.getPosition().equals(position)) { players.add(player); } }
    } }
    if (req.getServletPath().equals("/positions")) {
      Collections.sort(positions);
      dispatcher = req.getRequestDispatcher("/views/positions/index.jsp");
      req.setAttribute("positions", positions);
    } else {
      if (positions.contains(req.getParameter("name"))) {
        dispatcher = req.getRequestDispatcher("/views/positions/show.jsp");
        req.setAttribute("position", position);
        req.setAttribute("players", players);
      } else { dispatcher = req.getRequestDispatcher("/views/404.jsp"); }
    }
    dispatcher.forward(req, res);
  }
}