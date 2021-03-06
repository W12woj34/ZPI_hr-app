package pwr.zpi.hrapp.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity_;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity_;

@Data
public class ExperienceSpecification implements Specification<ExperienceEntity> {
  private final Integer employeeId;

  @Override
  public Predicate toPredicate(
      Root<ExperienceEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    if (employeeId != null) {
      cq.where(
          cb.and(
              cb.equal(root.get(ExperienceEntity_.employee).get(EmployeeEntity_.id), employeeId)));
    }

    return cq.getRestriction();
  }
}
