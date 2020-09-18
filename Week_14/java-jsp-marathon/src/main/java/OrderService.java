import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class OrderService {
  private EntityManager em;

  public OrderService(EntityManager em) {
    this.em = em;
  }

  public Boolean save(Order order) {
    try {
      em.getTransaction().begin();
      em.persist(order);
      em.getTransaction().commit();
      return true;
    } catch (Exception e) { return false; }
  }

  public Boolean deleteOrder(int orderId) {
    try {
      Query query = em.createNativeQuery("DELETE FROM orders WHERE ID = " + orderId);
      em.getTransaction().begin();
      query.executeUpdate();
      em.getTransaction().commit();
      return true;
    } catch (Exception e) { return false; }
  }

  public Boolean updateOrder(int orderId, String status) {
    try {
      Query query = em.createNativeQuery("UPDATE orders SET status = '" + status + "' WHERE ID = " + orderId);
      em.getTransaction().begin();
      query.executeUpdate();
      em.getTransaction().commit();
      return true;
    } catch (Exception e) { return false; }
  }

  public List<Order> findAll() { return em.createQuery("SELECT o FROM Order o", Order.class).getResultList(); }
  public List<Order> findOrdersByUsername(String username) { return em.createQuery("SELECT o FROM Order o WHERE o.username = '" + username + "'", Order.class).getResultList(); }
  public Order findOrderById(int orderId) { return em.createQuery("SELECT o FROM Order o WHERE o.id = " + orderId, Order.class).getSingleResult(); }
  public boolean orderExists(int orderId) { if (em.createQuery("SELECT COUNT(*) FROM Order o WHERE o.id = " + orderId, Long.class).getSingleResult() == 1) { return true; } else { return false; } }
}
