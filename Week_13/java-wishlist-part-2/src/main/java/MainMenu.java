import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MainMenu {

  private static Scanner input = new Scanner(System.in);
  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static Map<String, String> options;

  public enum MenuOption {
    a("Add a New Product to Wishlist"),
    l("View All Products in Wishlist"),
    c("View Products In a Category"),
    d("Remove a Product from the Wishlist"),
    r("Remove a Category from the Wishlist"),
    q("Exit");

    private String optionText;

    MenuOption(String optionText) {
      this.optionText = optionText;
    }

    @Override
    public String toString() { return this.optionText; }
  }

  @Override
  public String toString() {
    String output = "";
    int i = 1;
    for(MenuOption option : MenuOption.values()) { output += "  " + i++ + ". " + option.toString() + "\n"; }
    return output;
  }

  public void menu() {
    emf = Persistence.createEntityManagerFactory("com.launchacademy.wishlist");
    em = emf.createEntityManager();

    createMenu();
    printMenu();

    MenuOption inputOption;
    do{
      inputOption = null;
      System.out.print("> ");
      try {
        String userInput = input.next();
        if (options.containsKey(userInput)) { inputOption = MenuOption.valueOf(options.get(userInput)); }
        else { inputOption = MenuOption.valueOf("0"); }
      } catch(IllegalArgumentException error) { System.out.println("Please make a valid selection!"); }

      if(inputOption == MenuOption.a) { addProduct(); }
      else if(inputOption == MenuOption.l) { listProducts(); }
      else if(inputOption == MenuOption.c) { listProductsByCategory(); }
      else if(inputOption == MenuOption.d) { deleteProduct(); }
      else if(inputOption == MenuOption.r) { deleteCategory(); }
      if(inputOption != MenuOption.q) { printMenu(); }
    } while(inputOption != MenuOption.q);
    System.out.println("Thanks! Please return to your wishlist soon!");
    em.close();
    emf.close();
    input.close();
  }

  private void createMenu() {
    options = new HashMap<>();
    List<String> optionLetters = new ArrayList<>(Arrays.asList("a", "l", "c", "d", "r", "q"));
    for (int i = 0; i < optionLetters.size(); i++) { options.put(String.valueOf(i+1), optionLetters.get(i)); }
  }

  private void printMenu() { System.out.println("\nMain Menu:\n-------------------------------\n" + this.toString()); }

  private static String getStringInput(String prompt) {
    System.out.print(prompt);
    Scanner inputScanner = new Scanner(System.in);
    String inputStr = inputScanner.next();
    while (inputStr.isEmpty()) {
      System.out.print("Please input something: ");
      inputStr = inputScanner.nextLine();
    }
    return inputStr;
  }

  private static String promptYesNo(String prompt) {
    String inputStr = getStringInput(prompt);
    while (!inputStr.equals("y") && !inputStr.equals("n")) { inputStr = getStringInput("Please input either 'y' or 'n': "); }
    return inputStr;
  }

  private static Float promptFloat(String prompt) {
    String inputStr = getStringInput(prompt);
    boolean valid = false;
    Float value = null;
    do {
      try {
        value = Float.valueOf(inputStr);
        valid = true;
      } catch (NumberFormatException e) { inputStr = getStringInput("Please input a numeric value: "); }
    } while (!valid);
    return value;
  }

  private static Long promptLong(String prompt) {
    String inputStr = getStringInput(prompt);
    boolean valid = false;
    Long value = null;
    do {
      try {
        value = Long.valueOf(inputStr);
        valid = true;
      } catch (NumberFormatException e) { inputStr = getStringInput("Please input a numeric value: "); }
    } while (!valid);
    return value;
  }

  private void addProduct() {
    Product product = new Product();
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Product>> violations = validator.validate(product);

    if(violations.size() > 0) {
      for (ConstraintViolation<Product> violation : violations) {
        System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
      }
    } else {
      System.out.println("Ready to persist");
    }



//    try {
//      String productName = getStringInput("Enter a product name:\n> ");
//      if (productExists(productName)) {
//        System.out.println("Product: \"" + productName + "\" already exists in our database!");
//      } else {
//        Product product = new Product();
//        product.setName(productName);
//        product.setPrice(promptFloat("How much does it cost?\n> "));
//        product.setUrl(getStringInput("Enter a product URL:\n> "));
//        String addCategory = promptYesNo("Would you like to add a category? (y/n)\n> ");
//        if (addCategory.equals("y")) {
//          String categoryName = getStringInput("Enter a category name:\n> ");
//          if (categoryExists(categoryName)) { product.setCategory(getCategoryByName(categoryName)); }
//          else { product.setCategory(createCategory(categoryName)); }
//        }
//        em.getTransaction().begin();
//        em.persist(product);
//        em.getTransaction().commit();
//      }
//    } catch (Exception e) { e.printStackTrace(); }
  }

  private void listProducts() {
    List<Product> products = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    System.out.println("\nProducts:\n-------------------------------");
    for (Product product : products) { System.out.println(product.toDisplayString()); }
  }

  private void listCategories() {
    List<Category> categories = em.createQuery("SELECT c from Category c ORDER BY id", Category.class).getResultList();
    System.out.println("\nCategories:\n-------------------------------");
    for (Category category : categories) {
      TypedQuery<Long> countQuery = em.createQuery("SELECT COUNT(p) from Product p WHERE category_id = '" + category.getId() + "'", Long.class);
      Long numProducts = countQuery.getSingleResult();
      System.out.println("  " + category.getId() + ". " + category.getName() + " (" + numProducts + ")");
    }
  }

  private List<Product> getProductsByCategoryId(long categoryId) {
    List<Product> products = null;
    try {
      TypedQuery<Product> prodQuery = em.createQuery("SELECT p from Product p WHERE category_id = " + categoryId, Product.class);
      products = prodQuery.getResultList();
    } catch (Exception e) { e.printStackTrace(); }
    return products;
  }

  private void listProductsByCategoryId(long categoryId) {
    List<Product> products = getProductsByCategoryId(categoryId);
    try {
      for (Product product : products) { System.out.println(product.toDisplayString()); }
    } catch (Exception e) { e.printStackTrace(); }
  }

  private void listProductsByCategory() {
    listCategories();
    long categoryId = promptLong("\nEnter a category id:\n> ");
    listProductsByCategoryId(categoryId);
  }

  public boolean productExists(String productName) {
    List<Product> products = em.createQuery("SELECT p FROM Product p WHERE name = '" + productName + "'", Product.class).getResultList();
    if (products.size() > 0) { return true; } else { return false; }
  }

  public boolean categoryExists(String categoryName) {
    List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE name = '" + categoryName + "'", Category.class).getResultList();
    if (categories.size() > 0) { return true; } else { return false; }
  }

  public boolean categoryIdExists(long categoryId) {
    List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE id = " + categoryId, Category.class).getResultList();
    if (categories.size() > 0) { return true; } else { return false; }
  }

  public Category getCategoryByName(String categoryName) {
    List<Category> categories = em.createQuery("SELECT c FROM Category c WHERE name = '" + categoryName + "'", Category.class).getResultList();
    return categories.get(0);
  }

  public Category createCategory(String categoryName) {
    Category category = new Category();
    category.setName(categoryName);
    em.getTransaction().begin();
    em.persist(category);
    em.getTransaction().commit();
    return category;
  }

  public void deleteProductById(long productId) {
    try {
      Query query = em.createNativeQuery("DELETE FROM products WHERE ID = " + productId);
      em.getTransaction().begin();
      query.executeUpdate();
      em.getTransaction().commit();
    }  catch (Exception e) { e.printStackTrace(); }
  }

  public void deleteCategoryById(long categoryId) {
    List<Product> products = getProductsByCategoryId(categoryId);
    try {
      for (Product product : products) { deleteProductById(product.getId()); }
      Query query = em.createNativeQuery("DELETE FROM categories WHERE ID = " + categoryId);
      em.getTransaction().begin();
      query.executeUpdate();
      em.getTransaction().commit();
    }  catch (Exception e) { e.printStackTrace(); }
  }

  public void deleteProduct() {
    listProducts();
    long productId = promptLong("\nEnter a product id to delete:\n> ");
    deleteProductById(productId);
  }

  public void deleteCategory() {
    listCategories();
    long categoryId = promptLong("\nEnter a category id to delete:\n> ");
    deleteCategoryById(categoryId);
  }
}