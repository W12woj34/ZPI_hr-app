package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity extends BaseInheritedIdEntity<Integer> {

  @OneToOne
  @MapsId
  @JoinColumn(name = "id")
  private EmployeeEntity employee;

  private String mobile;
  private String email;
  private String git;
  private String linkedin;
  private String other;
}
