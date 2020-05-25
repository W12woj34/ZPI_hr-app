package pwr.zpi.hrapp.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;
import pwr.zpi.hrapp.persistance.entities.EducationEntity_;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity_;

@Data
public class EducationSpecification implements Specification<EducationEntity> {
  private final Integer employeeId;

  @Override
  public Predicate toPredicate(
      Root<EducationEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    if (employeeId != null) {
      cq.where(
          cb.and(
              cb.equal(root.get(EducationEntity_.employee).get(EmployeeEntity_.id), employeeId)));
    }

    return cq.getRestriction();
  }
}
