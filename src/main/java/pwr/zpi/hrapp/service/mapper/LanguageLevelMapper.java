package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.LanguageLevel;
import pwr.zpi.hrapp.persistance.entities.LanguageLevelEntity;

@Mapper
public interface LanguageLevelMapper extends BaseMapper<LanguageLevel, LanguageLevelEntity> {}
