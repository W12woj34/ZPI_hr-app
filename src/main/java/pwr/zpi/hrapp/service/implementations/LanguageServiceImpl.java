package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Language;
import pwr.zpi.hrapp.persistance.entities.LanguageEntity;
import pwr.zpi.hrapp.persistance.repositories.LanguageRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.LanguageService;
import pwr.zpi.hrapp.service.mapper.LanguageMapper;

@Service
public class LanguageServiceImpl
    extends BaseSpecificationCrudService<Language, LanguageEntity, Integer, LanguageRepository>
    implements LanguageService {

  public LanguageServiceImpl(LanguageRepository repository, LanguageMapper mapper) {
    super(repository, mapper);
  }
}
