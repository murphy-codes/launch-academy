import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/", "/orders", "/orders/new"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/404.jsp");
    if (req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();
      OrderService service = new OrderService(em);
      if (req.getParameter("orderId") != null) {
        if (service.orderExists(Integer.parseInt(req.getParameter("orderId")))) {
          dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
          req.setAttribute("order", service.findOrderById(Integer.parseInt(req.getParameter("orderId"))));
        }
      } else {
        try {
          req.setAttribute("orders", service.findAll());
          dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
        } catch (Exception e) { e.printStackTrace(); }
      }
      em.close();
    } else if (req.getServletPath().equals("/orders/new")) { dispatcher = req.getRequestDispatcher("/views/orders/new.jsp"); }
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try { BeanUtils.populate(order, req.getParameterMap()); }
      catch (IllegalAccessException e) { e.printStackTrace(); } // System.out.println("Error:\nBeansUtils could not find setter: \n");
      catch (InvocationTargetException e) { e.printStackTrace(); } // System.out.println("Error:\nBeansUtils had an error with the setter: \n");
      EntityManager em = getEmf().createEntityManager();
      OrderService service = new OrderService(getEmf().createEntityManager());
      service.save(order);
      em.close();
      resp.sendRedirect("/orders");
    } else { resp.sendError(HttpServletResponse.SC_NOT_FOUND); }
  }

  private EntityManagerFactory getEmf() { return (EntityManagerFactory)this.getServletContext().getAttribute("emf"); }
}
