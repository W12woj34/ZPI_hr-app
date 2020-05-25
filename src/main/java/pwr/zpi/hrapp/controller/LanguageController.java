package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Language;
import pwr.zpi.hrapp.service.LanguageService;

@RestController
@RequestMapping(RestMappings.LANGUAGE)
public class LanguageController extends BaseRestController<Language, Integer> {

  public LanguageController(LanguageService service) {
    super(service);
  }
}
