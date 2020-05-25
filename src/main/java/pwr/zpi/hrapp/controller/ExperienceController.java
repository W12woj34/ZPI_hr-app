package pwr.zpi.hrapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Experience;
import pwr.zpi.hrapp.service.ExperienceService;
import pwr.zpi.hrapp.specifications.ExperienceSpecification;

@RestController
@RequestMapping(RestMappings.EXPERIENCE)
public class ExperienceController extends BaseRestController<Experience, Integer> {
  ExperienceService service;

  public ExperienceController(ExperienceService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(RestMappings.SEARCH)
  public Page<Experience> getAllWithGivenParameters(
      ExperienceSpecification specification, Pageable pageable) {

    return service.findAll(specification, pageable);
  }
}
