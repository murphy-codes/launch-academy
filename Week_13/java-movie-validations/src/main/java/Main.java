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

//    em.getTransaction().begin();
    Movie movie = new Movie();
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
    for (ConstraintViolation<Movie> violation : violations) {
      System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
    }



//    em.persist(movie);
//    em.getTransaction().commit();



//    try {
//      // our database interactions can go here
//
//      // Find by ID
////      Movie movie = em.find(Movie.class, 2L);
////      System.out.println(movie);
////      System.out.println(movie.getId());
////      System.out.println(movie.getTitle());
//
//      // Find by title
////      TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE title = 'Troll 2'", Movie.class);
//      // Multiple results expected
////      List<Movie> movies = query.getResultList();
////      if(movies.size() > 0) {
////        System.out.println(movies.get(0).getTitle());
////      }
////      else {
////        System.out.println("NOT FOUND");
////      }
//      // Single result expected
////      Movie standalone = query.getSingleResult();
////      System.out.println(standalone.getTitle());
//      // Persisting an Entity
////      Movie movie = new Movie();
////      movie.setTitle("Tequila Mockingbird");
////      movie.setGenreId(2L);
////      movie.setYear(2025);
////      em.getTransaction().begin();
////      em.persist(movie);
////      em.getTransaction().commit();
////      System.out.println(movie.getId());
//      // Checking my work ...
////      Movie movie = em.find(Movie.class, 3549L);
////      System.out.println(movie);
////      System.out.println(movie.getId());
////      System.out.println(movie.getTitle());
////      System.out.println(movie.getRating());
//      // Updating the Entity
////      TypedQuery<Movie> retrieval = em.createQuery("SELECT m FROM Movie m WHERE title = 'Tequila Mockingbird'", Movie.class);
////      Movie bestEver = retrieval.getResultList().get(0);
////      em.getTransaction().begin();
////      bestEver.setRating(100);
////      em.getTransaction().commit();
//      // Updating via JPQL
////      em.getTransaction().begin();
////      Query updateQuery = em.createQuery("UPDATE Movie SET rating = :newRating WHERE title = 'Tequila Mockingbird'");
////      updateQuery.setParameter("newRating", 400);
////      int updateCount = updateQuery.executeUpdate();
////      em.getTransaction().commit();
//    }
//    finally {
//      em.close();
//      emf.close();
//    }
  }
}