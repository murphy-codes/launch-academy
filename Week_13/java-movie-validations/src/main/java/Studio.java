import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="studios")
public class Studio {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotBlank
  @Column(name="name", nullable=false)
  private String name;

  @Column(name="created_at")
  private String createdAt;

  @Column(name="updated_at")
  private String updatedAt;

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getCreatedAt() { return createdAt; }

  public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

  public String getUpdatedAt() { return updatedAt; }

  public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
