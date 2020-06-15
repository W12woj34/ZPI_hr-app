package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.LanguageKnowledge;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;
import pwr.zpi.hrapp.service.LanguageKnowledgeService;
import pwr.zpi.hrapp.specifications.LanguageKnowledgeSpecification;

@RestController
@RequestMapping(RestMappings.LANGUAGE_KNOWLEDGE)
public class LanguageKnowledgeController
    extends BaseSpecificationCrudController<
        LanguageKnowledge, Integer, LanguageKnowledgeEntity, LanguageKnowledgeSpecification> {

  public LanguageKnowledgeController(LanguageKnowledgeService service) {
    super(service);
  }
}
