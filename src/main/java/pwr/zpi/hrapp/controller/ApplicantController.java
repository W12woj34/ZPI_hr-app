package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Applicant;
import pwr.zpi.hrapp.persistance.entities.ApplicantEntity;
import pwr.zpi.hrapp.service.ApplicantService;
import pwr.zpi.hrapp.specifications.ApplicantSpecification;

@RestController
@RequestMapping(RestMappings.APPLICANT)
public class ApplicantController
    extends BaseSpecificationCrudController<
        Applicant, Integer, ApplicantEntity, ApplicantSpecification> {

  public ApplicantController(ApplicantService service) {
    super(service);
  }
}
