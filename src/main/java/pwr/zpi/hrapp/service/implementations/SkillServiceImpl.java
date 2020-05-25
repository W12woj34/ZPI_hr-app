package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Skill;
import pwr.zpi.hrapp.persistance.entities.SkillEntity;
import pwr.zpi.hrapp.persistance.repositories.SkillRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.SkillService;
import pwr.zpi.hrapp.service.mapper.SkillMapper;

@Service
public class SkillServiceImpl
    extends BaseSpecificationCrudService<Skill, SkillEntity, Integer, SkillRepository>
    implements SkillService {

  public SkillServiceImpl(SkillRepository repository, SkillMapper mapper) {
    super(repository, mapper);
  }
}
