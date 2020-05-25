package pwr.zpi.hrapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.SkillLevel;
import pwr.zpi.hrapp.service.SkillLevelService;
import pwr.zpi.hrapp.specifications.SkillLevelSpecification;

@RestController
@RequestMapping(RestMappings.SKILL_LEVEL)
public class SkillLevelController extends BaseRestController<SkillLevel, Integer> {
  private final SkillLevelService service;

  public SkillLevelController(SkillLevelService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(RestMappings.SEARCH)
  public Page<SkillLevel> getAllWithGivenParameters(
      SkillLevelSpecification specification, Pageable pageable) {

    return service.findAll(specification, pageable);
  }
}
