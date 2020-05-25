package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Education")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationEntity extends AbstractPersistable<Integer> {

  private String institution;

  @Column(name = "field_of_study")
  private String fieldOfStudy;

  @Column(name = "education_period")
  private String educationPeriod;

  private String degree;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private EmployeeEntity employee;
}
