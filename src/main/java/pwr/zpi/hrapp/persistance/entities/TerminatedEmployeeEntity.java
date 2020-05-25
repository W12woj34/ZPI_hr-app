package pwr.zpi.hrapp.persistance.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Terminated_Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminatedEmployeeEntity extends EmployeeEntity {

  private String availability;

  @Column(name = "next_date_contact")
  private LocalDate nextDateContact;
}
