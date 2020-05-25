package pwr.zpi.hrapp.persistance.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
public class EmployeeEntity extends PersonEntity {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "login_id")
  private LoginEntity login;

  @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
  private ContactEntity contact;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private Collection<EducationEntity> education;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private Collection<ExperienceEntity> experience;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private Collection<LanguageKnowledgeEntity> languagesKnowledge;

  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private Collection<SkillLevelEntity> skillLevels;
}
