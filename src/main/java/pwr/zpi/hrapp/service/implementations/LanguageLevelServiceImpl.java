package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.LanguageLevel;
import pwr.zpi.hrapp.persistance.entities.LanguageLevelEntity;
import pwr.zpi.hrapp.persistance.repositories.LanguageLevelRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.LanguageLevelService;
import pwr.zpi.hrapp.service.mapper.LanguageLevelMapper;

@Service
public class LanguageLevelServiceImpl
    extends BaseSpecificationCrudService<
        LanguageLevel, LanguageLevelEntity, Integer, LanguageLevelRepository>
    implements LanguageLevelService {

  public LanguageLevelServiceImpl(LanguageLevelRepository repository, LanguageLevelMapper mapper) {
    super(repository, mapper);
  }
}
