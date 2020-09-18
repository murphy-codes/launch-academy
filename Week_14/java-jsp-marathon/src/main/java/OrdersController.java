import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/", "/orders", "/orders/new", "/orders/cancel", "/orders/update"})
public class OrdersController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/404.jsp");
    boolean redirect = false;
    if (req.getServletPath().equals("/orders")) {
      EntityManager em = getEmf().createEntityManager();
      OrderService service = new OrderService(em);
      if (req.getParameter("orderId") != null) {
        if (service.orderExists(Integer.parseInt(req.getParameter("orderId")))) {
          dispatcher = req.getRequestDispatcher("/views/orders/show.jsp");
          req.setAttribute("order", service.findOrderById(Integer.parseInt(req.getParameter("orderId"))));
        }
      } else {
        HttpSession session = req.getSession();
        try {
          if (session.getAttribute("username") != null) { req.setAttribute("orders", service.findOrdersByUsername(session.getAttribute("username").toString())); }
          else { req.setAttribute("orders", service.findAll()); }
          dispatcher = req.getRequestDispatcher("/views/orders/index.jsp");
        } catch (Exception e) { e.printStackTrace(); }
      }
      em.close();
    } else if (req.getServletPath().equals("/orders/new")) {
      HttpSession session = req.getSession();
      req.setAttribute("username", session.getAttribute("username"));
      dispatcher = req.getRequestDispatcher("/views/orders/new.jsp");
    } else if (req.getServletPath().equals("/orders/cancel")) {
      if (req.getParameter("orderId") != null) {
        EntityManager em = getEmf().createEntityManager();
        OrderService service = new OrderService(em);
        try {
          service.deleteOrder(Integer.parseInt(req.getParameter("orderId")));
          redirect = true;
        } catch (Exception e) { e.printStackTrace(); }
        em.close();
      }
    } else if (req.getServletPath().equals("/orders/update")) {
      if (req.getParameter("orderId") != null) {
        EntityManager em = getEmf().createEntityManager();
        OrderService service = new OrderService(em);
        dispatcher = req.getRequestDispatcher("/views/orders/update.jsp");
        try{ req.setAttribute("order", service.findOrderById(Integer.parseInt(req.getParameter("orderId")))); } catch (Exception e) { e.printStackTrace(); }
        em.close();
      }
    }
    if (redirect) { resp.sendRedirect("/orders"); }
    else { dispatcher.forward(req, resp); }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/orders")) {
      Order order = new Order();
      try { BeanUtils.populate(order, req.getParameterMap()); }
      catch (IllegalAccessException e) { e.printStackTrace(); }
      catch (InvocationTargetException e) { e.printStackTrace(); }
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      Set<ConstraintViolation<Order>> violations;
      violations = validator.validate(order);
      if (violations.size() > 0) {
        req.setAttribute("violations", violations);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/orders/new.jsp");
        dispatcher.forward(req, resp);
      } else {
        EntityManager em = getEmf().createEntityManager();
        OrderService service = new OrderService(getEmf().createEntityManager());
        if(service.save(order)) {
          HttpSession session = req.getSession();
          session.setAttribute("username", order.getUsername());
        }
        em.close();
        resp.sendRedirect("/orders");
      }
    } else if (req.getServletPath().equals("/orders/update")) {
      if (Arrays.asList("confirmed","in progress","completed","cancelled").contains(req.getParameter("status"))) {
        EntityManager em = getEmf().createEntityManager();
        OrderService service = new OrderService(getEmf().createEntityManager());
        try{ service.updateOrder(Integer.parseInt(req.getParameter("orderId")),req.getParameter("status")); } catch (Exception e) { e.printStackTrace(); }
        em.close();
        resp.sendRedirect("/orders?orderId=" + req.getParameter("orderId"));
      } else { resp.sendError(HttpServletResponse.SC_NOT_FOUND); }
    }
    else { resp.sendError(HttpServletResponse.SC_NOT_FOUND); }
  }

  private EntityManagerFactory getEmf() { return (EntityManagerFactory)this.getServletContext().getAttribute("emf"); }
}
