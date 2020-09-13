import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blasters")
public class Blaster {
  @Id
  @SequenceGenerator(name = "blaster_generator", sequenceName = "blasters_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blaster_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "recharge_time", nullable = false)
  private Integer rechargeTime;

  @Column(name = "attachment")
  private String attachment;

  public Long getId() { return id; }

  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public Integer getRechargeTime() { return rechargeTime; }

  public void setRechargeTime(Integer rechargeTime) { this.rechargeTime = rechargeTime; }

  public String getAttachment() { return attachment; }

  public void setAttachment(String attachment) { this.attachment = attachment; }
}
