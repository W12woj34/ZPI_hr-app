package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Applicant;
import pwr.zpi.hrapp.persistance.entities.ApplicantEntity;
import pwr.zpi.hrapp.persistance.repositories.ApplicantRepository;
import pwr.zpi.hrapp.service.ApplicantService;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.mapper.ApplicantMapper;

@Service
public class ApplicantServiceImpl
    extends BaseSpecificationCrudService<Applicant, ApplicantEntity, Integer, ApplicantRepository>
    implements ApplicantService {

  public ApplicantServiceImpl(ApplicantRepository repository, ApplicantMapper mapper) {
    super(repository, mapper);
  }
}
