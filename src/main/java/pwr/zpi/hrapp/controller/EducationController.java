package pwr.zpi.hrapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Education;
import pwr.zpi.hrapp.service.EducationService;
import pwr.zpi.hrapp.specifications.EducationSpecification;

@RestController
@RequestMapping(RestMappings.EDUCATION)
public class EducationController extends BaseRestController<Education, Integer> {
  EducationService service;

  public EducationController(EducationService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(RestMappings.SEARCH)
  public Page<Education> getAllWithGivenParameters(
      EducationSpecification specification, Pageable pageable) {

    return service.findAll(specification, pageable);
  }
}
