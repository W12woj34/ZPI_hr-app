package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Education;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;
import pwr.zpi.hrapp.persistance.repositories.EducationRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.EducationService;
import pwr.zpi.hrapp.service.mapper.EducationMapper;

@Service
public class EducationServiceImpl
    extends BaseSpecificationCrudService<Education, EducationEntity, Integer, EducationRepository>
    implements EducationService {

  public EducationServiceImpl(EducationRepository repository, EducationMapper mapper) {
    super(repository, mapper);
  }
}
