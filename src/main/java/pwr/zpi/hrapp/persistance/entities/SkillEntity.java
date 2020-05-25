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
@Table(name = "Skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillEntity extends AbstractPersistable<Integer> {

  private String name;

  @ManyToOne
  @JoinColumn(name = "skill_category")
  private SkillCategoryEntity skillCategory;
}
