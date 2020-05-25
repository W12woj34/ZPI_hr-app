package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Education;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;

public interface EducationService
    extends SpecificationCrudService<Education, EducationEntity, Integer> {}
