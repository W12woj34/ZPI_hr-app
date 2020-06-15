package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  private final WorkingEmployeeService service;

  public WorkingEmployeeController(WorkingEmployeeService service) {
    super(service);
    this.service = service;
  }

  @PostMapping(RestMappings.TERMINATE)
  public void terminate(@PathVariable int id) {
    service.terminate(id);
  }
}
