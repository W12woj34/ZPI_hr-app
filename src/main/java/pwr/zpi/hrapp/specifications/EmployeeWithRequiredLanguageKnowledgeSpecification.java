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
import pwr.zpi.hrapp.dto.search.SearchLanguageKnowledge;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity_;
import pwr.zpi.hrapp.persistance.entities.LanguageEntity_;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity_;
import pwr.zpi.hrapp.persistance.entities.LanguageLevelEntity_;

@Data
public class EmployeeWithRequiredLanguageKnowledgeSpecification<T extends EmployeeEntity>
    implements Specification<T> {

  private final Collection<SearchLanguageKnowledge> searchLanguageKnowledges;

  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    CollectionJoin<T, LanguageKnowledgeEntity> languageKnowledgeJoin =
        root.join(EmployeeEntity_.languagesKnowledge);

    List<Predicate> predicates = new ArrayList<>();
    for (SearchLanguageKnowledge searchLanguageKnowledge : searchLanguageKnowledges) {
      Predicate languageIdPredicate =
          cb.equal(
              languageKnowledgeJoin.get(LanguageKnowledgeEntity_.language).get(LanguageEntity_.id),
              searchLanguageKnowledge.getLanguageId());
      Predicate languageLevelPredicate =
          cb.greaterThanOrEqualTo(
              languageKnowledgeJoin
                  .get(LanguageKnowledgeEntity_.languageLevel)
                  .get(LanguageLevelEntity_.level),
              searchLanguageKnowledge.getLevel());

      predicates.add(cb.and(languageIdPredicate, languageLevelPredicate));
    }

    return cq.where(cb.or(predicates.toArray(new Predicate[0])))
        .groupBy(languageKnowledgeJoin.get(LanguageKnowledgeEntity_.employee))
        .having(
            cb.equal(
                cb.countDistinct(
                    languageKnowledgeJoin
                        .get(LanguageKnowledgeEntity_.language)
                        .get(LanguageEntity_.id)),
                searchLanguageKnowledges.size()))
        .getRestriction();
  }
}
