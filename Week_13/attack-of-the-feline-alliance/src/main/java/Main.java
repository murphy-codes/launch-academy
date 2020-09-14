import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  private static EntityManagerFactory emf;
  private static EntityManager em;
  public static void main(String[] args) {
    emf = Persistence.createEntityManagerFactory("com.launchacademy.feline_alliance");
    em = emf.createEntityManager();

    Blaster blaster = new Blaster();
    blaster.setName("Lucky");
    blaster.setType("DL-44 heavy blaster pistol");
    blaster.setRechargeTime(30000);
    blaster.setAttachment("Scope");
    try {
      em.getTransaction().begin();
      em.persist(blaster);
      em.getTransaction().commit();
    } catch (Exception e) { e.printStackTrace(); }

    LaserCannon laserCannon = new LaserCannon();
    laserCannon.setName("B-wing R-9X heavy laser cannon 1");
    laserCannon.setRechargeTime(5000);
    laserCannon.setFireRate(4);
    laserCannon.setOverload(false);
    try {
      em.getTransaction().begin();
      em.persist(laserCannon);
      em.getTransaction().commit();
    } catch (Exception e) { e.printStackTrace(); }

    em.close();
    emf.close();
  }
}
