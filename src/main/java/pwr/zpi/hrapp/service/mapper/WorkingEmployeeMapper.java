package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.WorkingEmployee;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

@Mapper(uses = EntityFactory.class)
public interface WorkingEmployeeMapper extends BaseMapper<WorkingEmployee, WorkingEmployeeEntity> {}
