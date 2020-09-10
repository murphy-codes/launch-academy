import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @SequenceGenerator(name = "product_generator", sequenceName = "products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "price", precision=8, scale=2)
  private Float price;

  @Column(name = "featured")
  private boolean featured;

  @Column(name = "description")
  private String description;

  @Column(name = "category_id", insertable = false, updatable = false)
  private Long categoryId;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Long getId() { return id; }

  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public Float getPrice() { return price; }

  public void setPrice(Float price) { this.price = price; }

  public boolean isFeatured() { return featured; }

  public void setFeatured(boolean featured) { this.featured = featured; }

  public String getDescription() { return description; }

  public void setDescription(String description) { this.description = description; }

  public Long getCategoryId() { return categoryId; }

  public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

  public Category getCategory() { return category; }

  public void setCategory(Category category) { this.category = category; }
}
