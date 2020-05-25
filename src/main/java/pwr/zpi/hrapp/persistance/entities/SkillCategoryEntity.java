package pwr.zpi.hrapp.persistance.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Skill_Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillCategoryEntity extends AbstractPersistable<Integer> {

  private String name;

  @OneToMany(mappedBy = "skillCategory", fetch = FetchType.LAZY)
  private Collection<SkillEntity> skills;
}
