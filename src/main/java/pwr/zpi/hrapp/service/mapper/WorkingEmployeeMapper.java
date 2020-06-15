package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pwr.zpi.hrapp.dto.WorkingEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

@Mapper(uses = EntityFactory.class)
public abstract class WorkingEmployeeMapper
    implements BaseMapper<WorkingEmployee, WorkingEmployeeEntity> {
  @Mapping(source = "login.id", target = "loginId")
  @Override
  public abstract WorkingEmployee mapToDto(WorkingEmployeeEntity entity);

  @Override
  public abstract WorkingEmployeeEntity mapToEntity(WorkingEmployee dto);

  public abstract TerminatedEmployeeEntity mapWorkingToTerminatedEmployee(
      WorkingEmployeeEntity entity);
}
