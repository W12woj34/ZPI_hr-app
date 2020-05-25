package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Skill;
import pwr.zpi.hrapp.service.SkillService;

@RestController
@RequestMapping(RestMappings.SKILL)
public class SkillController extends BaseRestController<Skill, Integer> {

  public SkillController(SkillService service) {
    super(service);
  }
}
