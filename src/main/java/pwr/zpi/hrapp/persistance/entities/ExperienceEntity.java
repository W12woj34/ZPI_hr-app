package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceEntity extends AbstractPersistable<Integer> {

  @Column(name = "company_name")
  private String companyName;

  private String position;

  @Column(name = "working_period")
  private String workingPeriod;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private EmployeeEntity employee;
}
