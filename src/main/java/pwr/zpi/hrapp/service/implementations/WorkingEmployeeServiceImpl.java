package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.WorkingEmployee;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;
import pwr.zpi.hrapp.persistance.repositories.WorkingEmployeeRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.WorkingEmployeeService;
import pwr.zpi.hrapp.service.mapper.WorkingEmployeeMapper;

@Service
public class WorkingEmployeeServiceImpl
    extends BaseSpecificationCrudService<
        WorkingEmployee, WorkingEmployeeEntity, Integer, WorkingEmployeeRepository>
    implements WorkingEmployeeService {

  public WorkingEmployeeServiceImpl(
      WorkingEmployeeRepository repository, WorkingEmployeeMapper mapper) {
    super(repository, mapper);
  }
}
