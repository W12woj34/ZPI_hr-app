package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pwr.zpi.hrapp.dto.TerminatedEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Mapper(uses = EntityFactory.class)
public abstract class TerminatedEmployeeMapper
    implements BaseMapper<TerminatedEmployee, TerminatedEmployeeEntity> {
  @Mapping(source = "login.id", target = "loginId")
  @Override
  public abstract TerminatedEmployee mapToDto(TerminatedEmployeeEntity entity);

  @Override
  public abstract TerminatedEmployeeEntity mapToEntity(TerminatedEmployee dto);
}
