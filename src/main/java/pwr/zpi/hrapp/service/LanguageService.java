package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Language;
import pwr.zpi.hrapp.persistance.entities.LanguageEntity;

public interface LanguageService
    extends SpecificationCrudService<Language, LanguageEntity, Integer> {}
