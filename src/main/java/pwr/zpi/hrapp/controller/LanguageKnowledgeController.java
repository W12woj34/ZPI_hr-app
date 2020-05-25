package pwr.zpi.hrapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.LanguageKnowledge;
import pwr.zpi.hrapp.service.LanguageKnowledgeService;
import pwr.zpi.hrapp.specifications.LanguageKnowledgeSpecification;

@RestController
@RequestMapping(RestMappings.LANGUAGE_KNOWLEDGE)
public class LanguageKnowledgeController extends BaseRestController<LanguageKnowledge, Integer> {
  LanguageKnowledgeService service;

  public LanguageKnowledgeController(LanguageKnowledgeService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(RestMappings.SEARCH)
  public Page<LanguageKnowledge> getAllWithGivenParameters(
      LanguageKnowledgeSpecification specification, Pageable pageable) {

    return service.findAll(specification, pageable);
  }
}
