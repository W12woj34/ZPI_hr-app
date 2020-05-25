package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Employee;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.EmployeeService;
import pwr.zpi.hrapp.service.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl
    extends BaseSpecificationCrudService<Employee, EmployeeEntity, Integer, EmployeeRepository>
    implements EmployeeService {

  public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
    super(repository, mapper);
  }
}
