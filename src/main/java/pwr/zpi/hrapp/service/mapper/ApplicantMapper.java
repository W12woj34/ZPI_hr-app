package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Applicant;
import pwr.zpi.hrapp.persistance.entities.ApplicantEntity;

@Mapper(uses = EntityFactory.class)
public interface ApplicantMapper extends BaseMapper<Applicant, ApplicantEntity> {}
