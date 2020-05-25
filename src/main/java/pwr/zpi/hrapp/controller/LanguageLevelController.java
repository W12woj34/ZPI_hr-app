package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.LanguageLevel;
import pwr.zpi.hrapp.service.LanguageLevelService;

@RestController
@RequestMapping(RestMappings.LANGUAGE_LEVEL)
public class LanguageLevelController extends BaseRestController<LanguageLevel, Integer> {

  public LanguageLevelController(LanguageLevelService service) {
    super(service);
  }
}
