import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.movie_database");
    EntityManager em = emf.createEntityManager();

    Movie movie = new Movie();
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
    for (ConstraintViolation<Movie> violation : violations) {
      System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
    }

//    em.getTransaction().begin();
//    em.persist(movie);
//    em.getTransaction().commit();
  }
}