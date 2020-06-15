package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Experience;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;
import pwr.zpi.hrapp.service.ExperienceService;
import pwr.zpi.hrapp.specifications.ExperienceSpecification;

@RestController
@RequestMapping(RestMappings.EXPERIENCE)
public class ExperienceController
    extends BaseSpecificationCrudController<
        Experience, Integer, ExperienceEntity, ExperienceSpecification> {

  public ExperienceController(ExperienceService service) {
    super(service);
  }
}
