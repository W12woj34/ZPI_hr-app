package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.LanguageKnowledge;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;
import pwr.zpi.hrapp.persistance.repositories.LanguageKnowledgeRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.LanguageKnowledgeService;
import pwr.zpi.hrapp.service.mapper.LanguageKnowledgeMapper;

@Service
public class LanguageKnowledgeServiceImpl
    extends BaseSpecificationCrudService<
        LanguageKnowledge, LanguageKnowledgeEntity, Integer, LanguageKnowledgeRepository>
    implements LanguageKnowledgeService {

  public LanguageKnowledgeServiceImpl(
      LanguageKnowledgeRepository repository, LanguageKnowledgeMapper mapper) {
    super(repository, mapper);
  }
}
