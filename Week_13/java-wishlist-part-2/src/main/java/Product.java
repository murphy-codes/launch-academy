import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @SequenceGenerator(name = "product_generator", sequenceName = "products_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotBlank
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Digits(integer=7, fraction=2)
  @Column(name = "price", precision=8, scale=2) // @Column(name = "price")
  private Float price;

  @Pattern(regexp="http?s:.*", message = "must start with 'http:' or 'https:'")
  @Column(name = "url", nullable = false)
  private String url;

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

  public String getUrl() { return url; }

  public void setUrl(String url) { this.url = url; }

  public Long getCategoryId() { return categoryId; }

  public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

  public Category getCategory() { return category; }

  public void setCategory(Category category) { this.category = category; }

  public String toDisplayString() { return "  " + id + ". " + name + " " + price + " " + url + " " + (category != null ? category.getName() : ""); }
}
