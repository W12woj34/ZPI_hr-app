package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Skill;
import pwr.zpi.hrapp.persistance.entities.SkillEntity;

@Mapper(uses = {EntityFactory.class, SkillCategoryMapper.class})
public interface SkillMapper extends BaseMapper<Skill, SkillEntity> {}
