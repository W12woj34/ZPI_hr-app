package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.TerminatedEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;
import pwr.zpi.hrapp.persistance.repositories.TerminatedEmployeeRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.TerminatedEmployeeService;
import pwr.zpi.hrapp.service.mapper.TerminatedEmployeeMapper;

@Service
public class TerminatedEmployeeServiceImpl
    extends BaseSpecificationCrudService<
        TerminatedEmployee, TerminatedEmployeeEntity, Integer, TerminatedEmployeeRepository>
    implements TerminatedEmployeeService {

  public TerminatedEmployeeServiceImpl(
      TerminatedEmployeeRepository repository, TerminatedEmployeeMapper mapper) {
    super(repository, mapper);
  }
}
