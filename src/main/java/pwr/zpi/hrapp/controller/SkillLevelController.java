package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.SkillLevel;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.service.SkillLevelService;
import pwr.zpi.hrapp.specifications.SkillLevelSpecification;

@RestController
@RequestMapping(RestMappings.SKILL_LEVEL)
public class SkillLevelController
    extends BaseSpecificationCrudController<
        SkillLevel, Integer, SkillLevelEntity, SkillLevelSpecification> {

  public SkillLevelController(SkillLevelService service) {
    super(service);
  }
}
