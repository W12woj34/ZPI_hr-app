package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Working_Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingEmployeeEntity extends EmployeeEntity {
  private String position;
}
