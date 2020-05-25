package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Language;
import pwr.zpi.hrapp.persistance.entities.LanguageEntity;

@Mapper
public interface LanguageMapper extends BaseMapper<Language, LanguageEntity> {}
