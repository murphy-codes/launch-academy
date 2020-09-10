import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
  public static void main(String[] args) {
    // load the hibernate configure file
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    configuration.addResource("Quote.hbm.xml");

    // Create the Hibernate service Registry
    // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
      applySettings(configuration.
      getProperties()).
      build();

    // instantiate the session factory
    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    Session session = sessionFactory.getCurrentSession();

    session.beginTransaction();
    Quote quote = new Quote();
    quote.setQuote("I am guided by a force much greater than luck.");
    quote.setAuthor("Lucas NoIdeaWhatHisLastNameIs");
    quote.setSubject("Gambling");
    session.save(quote);
    session.getTransaction().commit();
    sessionFactory.close();
  }
}