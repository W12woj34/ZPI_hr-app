package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.TerminatedEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

public interface TerminatedEmployeeService
    extends SpecificationCrudService<TerminatedEmployee, TerminatedEmployeeEntity, Integer> {}
