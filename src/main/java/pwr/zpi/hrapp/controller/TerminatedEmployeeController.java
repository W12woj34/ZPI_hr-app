package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.TerminatedEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;
import pwr.zpi.hrapp.service.TerminatedEmployeeService;
import pwr.zpi.hrapp.specifications.TerminatedEmployeeSpecification;

@RestController
@RequestMapping(RestMappings.TERMINATED_EMPLOYEE)
public class TerminatedEmployeeController
    extends EmployeeController<
        TerminatedEmployee, TerminatedEmployeeEntity, TerminatedEmployeeSpecification> {

  public TerminatedEmployeeController(TerminatedEmployeeService service) {
    super(service);
  }
}
