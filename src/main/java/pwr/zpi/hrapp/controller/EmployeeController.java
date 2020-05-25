package pwr.zpi.hrapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Employee;
import pwr.zpi.hrapp.dto.search.EmployeeSearchLists;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.service.SpecificationCrudService;
import pwr.zpi.hrapp.specifications.EmployeeWithRequiredLanguageKnowledgeSpecification;
import pwr.zpi.hrapp.specifications.EmployeeWithRequiredSkillLevelsSpecification;

@RestController
public abstract class EmployeeController<
        T extends Employee, E extends EmployeeEntity, S extends Specification<E>>
    extends BaseRestController<T, Integer> {
  SpecificationCrudService<T, E, Integer> service;

  public EmployeeController(SpecificationCrudService<T, E, Integer> service) {
    super(service);
    this.service = service;
  }

  @PostMapping(RestMappings.SEARCH)
  public Page<T> getAllWithGivenParameters(
      @RequestBody(required = false) @Valid EmployeeSearchLists employeeSearchLists,
      S specification,
      Pageable pageable) {

    Specification<E> requiredSkillLevelsSpecification = Specification.where(null);
    Specification<E> requiredLanguageKnowledgesSpecification = Specification.where(null);

    if (employeeSearchLists != null) {
      if (employeeSearchLists.getSearchSkillLevels() != null
          && employeeSearchLists.getSearchSkillLevels().getList() != null
          && !employeeSearchLists.getSearchSkillLevels().getList().isEmpty()) {
        requiredSkillLevelsSpecification =
            new EmployeeWithRequiredSkillLevelsSpecification<>(
                employeeSearchLists.getSearchSkillLevels().getList());
      }
      if (employeeSearchLists.getSearchLanguageKnowledges() != null
          && employeeSearchLists.getSearchLanguageKnowledges().getList() != null
          && !employeeSearchLists.getSearchLanguageKnowledges().getList().isEmpty()) {
        requiredLanguageKnowledgesSpecification =
            new EmployeeWithRequiredLanguageKnowledgeSpecification<>(
                employeeSearchLists.getSearchLanguageKnowledges().getList());
      }
    }

    Specification<E> finalRequiredLanguageKnowledgesSpecification =
        requiredLanguageKnowledgesSpecification;
    List<T> collect =
        service
            .findAll(specification.and(requiredSkillLevelsSpecification), pageable)
            .filter(
                o ->
                    service
                        .findAll(specification.and(finalRequiredLanguageKnowledgesSpecification))
                        .contains(o))
            .get()
            .collect(Collectors.toList());

    return new PageImpl<>(collect, pageable, collect.size());
  }
}
