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
@Table(name = "Language_Knowledge")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageKnowledgeEntity extends AbstractPersistable<Integer> {

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private EmployeeEntity employee;

  @ManyToOne
  @JoinColumn(name = "language_id")
  private LanguageEntity language;

  @ManyToOne
  @JoinColumn(name = "level_id")
  private LanguageLevelEntity languageLevel;
}
