import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Seeder {
  public static String CATALOG_FILE_PATH = "catalog.json";
  private static EntityManagerFactory emf;
  private static EntityManager em;

  public static void main(String[] args) throws IOException {
    List<HashMap<String, String>> catalogList;
    ObjectMapper objectMapper = new ObjectMapper();
    catalogList = objectMapper.readValue(new File(Seeder.class.getResource(CATALOG_FILE_PATH).getFile()), ArrayList.class);

    if (catalogList.size() > 0) {
      emf = Persistence.createEntityManagerFactory("com.launchacademy.launch_catalog");
      em = emf.createEntityManager();
      catalogList.forEach(catalogProduct -> {
        if (productExists(catalogProduct.get("name"))) {
          System.out.println("Product: \"" + catalogProduct.get("name") + "\" already exists in our database!");
        } else {
          Product product = new Product();
          product.setName(catalogProduct.get("name"));
          product.setDescription(catalogProduct.get("description"));
          product.setPrice(Float.parseFloat(catalogProduct.get("price")));
          product.setFeatured(Boolean.parseBoolean(catalogProduct.get("featured")));
          String categoryName =  catalogProduct.get("category_name");
          if (categoryExists(categoryName)) { product.setCategory(getCategoryByName(categoryName)); }
          else { product.setCategory(createCategory(categoryName)); }
          em.getTransaction().begin();
          em.persist(product);
          em.getTransaction().commit();
        }
      });
      em.close();
      emf.close();
    }
  }

  public static boolean productExists(String productName) {
    List<Product> products = em.createQuery("SELECT p FROM Product p WHERE name = '" + productName + "'", Product.class).getResultList();
    if (products.size() > 0) { return true; } else { return false; }
  }

  public static boolean categoryExists(String categoryName) {
    List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE name = '" + categoryName + "'", Category.class).getResultList();
    if (categories.size() > 0) { return true; } else { return false; }
  }

  public static Category getCategoryByName(String categoryName) {
    List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE name = '" + categoryName + "'", Category.class).getResultList();
    return categories.get(0);
  }

  public static Category createCategory(String categoryName) {
    Category category = new Category();
    category.setName(categoryName);
    em.getTransaction().begin();
    em.persist(category);
    em.getTransaction().commit();
    return category;
  }
}
