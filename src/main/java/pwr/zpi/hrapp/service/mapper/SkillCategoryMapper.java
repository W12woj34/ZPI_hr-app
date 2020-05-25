package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.SkillCategory;
import pwr.zpi.hrapp.persistance.entities.SkillCategoryEntity;

@Mapper
public interface SkillCategoryMapper extends BaseMapper<SkillCategory, SkillCategoryEntity> {}
