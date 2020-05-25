package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.SkillCategory;
import pwr.zpi.hrapp.service.SkillCategoryService;

@RestController
@RequestMapping(RestMappings.SKILL_CATEGORY)
public class SkillCategoryController extends BaseRestController<SkillCategory, Integer> {

  public SkillCategoryController(SkillCategoryService service) {
    super(service);
  }
}
