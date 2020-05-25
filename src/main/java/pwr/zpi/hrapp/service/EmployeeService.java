package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Employee;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;

public interface EmployeeService
    extends SpecificationCrudService<Employee, EmployeeEntity, Integer> {}
