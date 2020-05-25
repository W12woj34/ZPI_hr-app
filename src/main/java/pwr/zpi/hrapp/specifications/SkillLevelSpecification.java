package pwr.zpi.hrapp.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity_;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity_;

@Data
public class SkillLevelSpecification implements Specification<SkillLevelEntity> {
  private final Integer employeeId;

  @Override
  public Predicate toPredicate(
      Root<SkillLevelEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

    if (employeeId != null) {
      cq.where(
          cb.and(
              cb.equal(root.get(SkillLevelEntity_.employee).get(EmployeeEntity_.id), employeeId)));
    }

    return cq.getRestriction();
  }
}
