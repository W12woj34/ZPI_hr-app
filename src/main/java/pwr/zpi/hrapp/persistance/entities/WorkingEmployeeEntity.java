package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Working_Employee")
@Data
@NoArgsConstructor
public class WorkingEmployeeEntity extends EmployeeEntity {}
