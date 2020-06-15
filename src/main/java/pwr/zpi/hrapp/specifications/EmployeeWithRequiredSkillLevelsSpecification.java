package pwr.zpi.hrapp.specifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.criteria.CollectionJoin;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.dto.search.SearchSkillLevel;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity_;
import pwr.zpi.hrapp.persistance.entities.SkillEntity_;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity_;

@Data
public class EmployeeWithRequiredSkillLevelsSpecification<T extends EmployeeEntity>
    implements Specification<T> {

  private final Collection<SearchSkillLevel> searchSkillLevels;

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    CollectionJoin<T, SkillLevelEntity> skillLevelJoin = root.join(EmployeeEntity_.skillLevels);

    List<Predicate> skillLevelPredicates = new ArrayList<>();
    for (SearchSkillLevel searchSkillLevel : searchSkillLevels) {
      Predicate skillIdPredicate =
          cb.equal(
              skillLevelJoin.get(SkillLevelEntity_.skill).get(SkillEntity_.id),
              searchSkillLevel.getSkillId());
      Predicate skillLevelPredicate =
          cb.greaterThanOrEqualTo(
              skillLevelJoin.get(SkillLevelEntity_.level), searchSkillLevel.getLevel());

      skillLevelPredicates.add(cb.and(skillIdPredicate, skillLevelPredicate));
    }

    return cq.where(cb.or(skillLevelPredicates.toArray(new Predicate[0])))
        .groupBy(skillLevelJoin.get(SkillLevelEntity_.employee))
        .having(
            cb.equal(
                cb.countDistinct(skillLevelJoin.get(SkillLevelEntity_.skill).get(SkillEntity_.id)),
                searchSkillLevels.size()))
        .getRestriction();
  }
}
