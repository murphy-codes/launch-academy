import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="movies")
public class Movie {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotNull(message = "can't be blank")
  @Length(min=1, max=255)
  @Column(name="title", nullable=false)
  private String title;

  @NotNull(message = "can't be blank")
  @Min(1920)
  @Column(name="year", nullable=false)
  private Integer year;

  @Column(name="synopsis")
  private String synopsis;

  @Min(value = 0, message = "must be between 0-100, inclusive")
  @Max(value = 100, message = "must be between 0-100, inclusive")
  @Column(name="rating")
  private Integer rating;

  @Column(name="created_at")
  private Timestamp createdAt;

  @Column(name="updated_at")
  private Timestamp updatedAt;

//  @NotNull(message = "can't be blank")
  @Column(name="genre_id", nullable=false)
  private Long genreId;

  @Column(name="studio_id")
  private Long studioId;

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public long getGenreId() {
    return genreId;
  }

  public void setGenreId(Long genreId) {
    this.genreId = genreId;
  }

  public long getStudioId() {
    return studioId;
  }

  public void setStudio_id(Long studio_id) {
    this.studioId = studioId;
  }
}
