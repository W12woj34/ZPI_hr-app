package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Employee;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;

@Mapper(uses = PersonMapper.class)
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeEntity> {}
