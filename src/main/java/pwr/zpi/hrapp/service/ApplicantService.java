package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Applicant;
import pwr.zpi.hrapp.persistance.entities.ApplicantEntity;

public interface ApplicantService
    extends SpecificationCrudService<Applicant, ApplicantEntity, Integer> {}
