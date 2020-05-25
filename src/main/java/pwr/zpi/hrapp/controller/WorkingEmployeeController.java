package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.WorkingEmployee;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;
import pwr.zpi.hrapp.service.WorkingEmployeeService;
import pwr.zpi.hrapp.specifications.WorkingEmployeeSpecification;

@RestController
@RequestMapping(RestMappings.WORKING_EMPLOYEE)
public class WorkingEmployeeController
    extends EmployeeController<
        WorkingEmployee, WorkingEmployeeEntity, WorkingEmployeeSpecification> {

  public WorkingEmployeeController(WorkingEmployeeService service) {
    super(service);
  }
}
