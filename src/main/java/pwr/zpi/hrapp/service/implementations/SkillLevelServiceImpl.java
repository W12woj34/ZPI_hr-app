package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.SkillLevel;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.persistance.repositories.SkillLevelRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.SkillLevelService;
import pwr.zpi.hrapp.service.mapper.SkillLevelMapper;

@Service
public class SkillLevelServiceImpl
    extends BaseSpecificationCrudService<
        SkillLevel, SkillLevelEntity, Integer, SkillLevelRepository>
    implements SkillLevelService {

  public SkillLevelServiceImpl(SkillLevelRepository repository, SkillLevelMapper mapper) {
    super(repository, mapper);
  }
}
