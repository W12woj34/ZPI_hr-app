package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.WorkingEmployee;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

public interface WorkingEmployeeService
    extends SpecificationCrudService<WorkingEmployee, WorkingEmployeeEntity, Integer> {}
