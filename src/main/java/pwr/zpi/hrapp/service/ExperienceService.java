package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Experience;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;

public interface ExperienceService
    extends SpecificationCrudService<Experience, ExperienceEntity, Integer> {}
