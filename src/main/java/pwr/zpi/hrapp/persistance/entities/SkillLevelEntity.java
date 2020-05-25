package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Skill_Level")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillLevelEntity extends AbstractPersistable<Integer> {

  private Integer level;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private EmployeeEntity employee;

  @ManyToOne
  @JoinColumn(name = "skill_id")
  private SkillEntity skill;
}
