package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.SkillCategory;
import pwr.zpi.hrapp.persistance.entities.SkillCategoryEntity;
import pwr.zpi.hrapp.persistance.repositories.SkillCategoryRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.SkillCategoryService;
import pwr.zpi.hrapp.service.mapper.SkillCategoryMapper;

@Service
public class SkillCategoryServiceImpl
    extends BaseSpecificationCrudService<
        SkillCategory, SkillCategoryEntity, Integer, SkillCategoryRepository>
    implements SkillCategoryService {

  public SkillCategoryServiceImpl(SkillCategoryRepository repository, SkillCategoryMapper mapper) {
    super(repository, mapper);
  }
}
