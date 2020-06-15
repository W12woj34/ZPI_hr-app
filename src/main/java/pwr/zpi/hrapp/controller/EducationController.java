package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Education;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;
import pwr.zpi.hrapp.service.EducationService;
import pwr.zpi.hrapp.specifications.EducationSpecification;

@RestController
@RequestMapping(RestMappings.EDUCATION)
public class EducationController
    extends BaseSpecificationCrudController<
        Education, Integer, EducationEntity, EducationSpecification> {

  public EducationController(EducationService service) {
    super(service);
  }
}
