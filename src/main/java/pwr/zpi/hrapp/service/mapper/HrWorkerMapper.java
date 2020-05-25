package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.HrWorker;
import pwr.zpi.hrapp.persistance.entities.HrWorkerEntity;

@Mapper(uses = {PersonMapper.class, EntityFactory.class})
public interface HrWorkerMapper extends BaseMapper<HrWorker, HrWorkerEntity> {}
