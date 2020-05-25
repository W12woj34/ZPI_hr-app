package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.TerminatedEmployee;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Mapper(uses = EntityFactory.class)
public interface TerminatedEmployeeMapper
    extends BaseMapper<TerminatedEmployee, TerminatedEmployeeEntity> {}
