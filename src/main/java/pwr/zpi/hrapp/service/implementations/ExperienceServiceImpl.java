package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Experience;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;
import pwr.zpi.hrapp.persistance.repositories.ExperienceRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.ExperienceService;
import pwr.zpi.hrapp.service.mapper.ExperienceMapper;

@Service
public class ExperienceServiceImpl
    extends BaseSpecificationCrudService<
        Experience, ExperienceEntity, Integer, ExperienceRepository>
    implements ExperienceService {

  public ExperienceServiceImpl(ExperienceRepository repository, ExperienceMapper mapper) {
    super(repository, mapper);
  }
}
