import java.util.List;
import javax.persistence.EntityManager;
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

  public List<Order> findAll() { return em.createQuery("SELECT o FROM Order o", Order.class).getResultList(); }

  public Order findOrderById(int orderId) { return em.createQuery("SELECT o FROM Order o WHERE o.id = " + orderId, Order.class).getSingleResult(); }

  public boolean orderExists(int orderId) {
    if (em.createQuery("SELECT COUNT(*) FROM Order o WHERE o.id = " + orderId, Long.class).getSingleResult() == 1) { return true; } else { return false; }
  }
}
