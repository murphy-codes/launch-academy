import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Trivia {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.movies");
    EntityManager em = emf.createEntityManager();

    try {
      //  What titles were released in 2001? ---------------------------------------------------------------------------
      TypedQuery<Movie> movieQuery = em.createQuery("SELECT m FROM Movie m WHERE year = 2001", Movie.class);
      List<Movie> titles2001 = movieQuery.getResultList();
      System.out.println(titles2001.size() + " movies released in 2001: \n----------------------------------------------");
//      for (Movie title: titles2001) {
//        System.out.println(title.getTitle());
//      }

      //  What titles were released in 2002 and had a rating higher than 90? -------------------------------------------
      movieQuery = em.createQuery("SELECT m FROM Movie m WHERE year = 2001 AND rating > 90", Movie.class);
      List<Movie> titles2001W90PlusRating = movieQuery.getResultList();
      System.out.println("\n" + titles2001W90PlusRating.size() + " movies released in 2001 w/ a rating of 90+: \n----------------------------------------------");
//      for (Movie title: titles2001W90PlusRating) {
//        System.out.println(title.getTitle());
//      }

      //  What actors have the last name of Wilson? --------------------------------------------------------------------
      TypedQuery<Actor> actorQuery = em.createQuery("SELECT a FROM Actor a WHERE name LIKE '% Wilson'", Actor.class);
      List<Actor> lastNameWilson = actorQuery.getResultList();
      System.out.println("\n" + lastNameWilson.size() + " actors with a last name of 'Wilson': \n----------------------------------------------");
//      for (Actor actor: lastNameWilson) {
//        System.out.println(actor.getName());
//      }

      //  What actors have the first name of Owen? ---------------------------------------------------------------------
      actorQuery = em.createQuery("SELECT a FROM Actor a WHERE name LIKE 'Owen %'", Actor.class);
      List<Actor> firstNameOwen = actorQuery.getResultList();
      System.out.println("\n" + firstNameOwen.size() + " actors with a first name of 'Owen': \n----------------------------------------------");
//      for (Actor actor: firstNameOwen) {
//        System.out.println(actor.getName());
//      }

      //  What studios start with "Fox"? -------------------------------------------------------------------------------
      TypedQuery<Studio> studioQuery = em.createQuery("SELECT s FROM Studio s WHERE name LIKE 'Fox%'", Studio.class);
      List<Studio> studiosFoxBeginning = studioQuery.getResultList();
      System.out.println("\n" + studiosFoxBeginning.size() + " studios start with 'Fox': \n----------------------------------------------");
//      for (Studio studio: studiosFoxBeginning) {
//        System.out.println(studio.getName());
//      }

      //  What studios involve Disney? ---------------------------------------------------------------------------------
      studioQuery = em.createQuery("SELECT s FROM Studio s WHERE name LIKE '%Disney%'", Studio.class); // ILIKE
      List<Studio> studiosInvolvingDisney = studioQuery.getResultList();
      System.out.println("\n" + studiosInvolvingDisney.size() + " studios involve 'Disney': \n----------------------------------------------");
//      for (Studio studio: studiosInvolvingDisney) {
//        System.out.println(studio.getName());
//      }


      //  What were the top 5 rated movies in 2004? --------------------------------------------------------------------
      movieQuery = em.createQuery("SELECT m FROM Movie m WHERE year = 2004 AND rating > 90 ORDER BY rating DESC", Movie.class);
      List<Movie> top5Titles2004 = movieQuery.setMaxResults(5).getResultList();
      System.out.println("\nThe top 5 movies in 2004 were: \n----------------------------------------------");
      for (Movie title: top5Titles2004) {
        System.out.println("(" + title.getRating() + "/100) " + title.getTitle());
      }

      //  What were the worst 10 movie titles and their ratings in 2003? -----------------------------------------------
      movieQuery = em.createQuery("SELECT m FROM Movie m WHERE year = 2003 ORDER BY rating", Movie.class);
      List<Movie> tenWorstTitles2003 = movieQuery.setMaxResults(10).getResultList();
      System.out.println("\nThe 10 worst movies of 2003 were: \n----------------------------------------------");
      for (Movie title: tenWorstTitles2003) {
        System.out.println("(" + title.getRating() + "/100) " + title.getTitle());
      }
    } finally {
      em.close();
      emf.close();
    }
  }
}
