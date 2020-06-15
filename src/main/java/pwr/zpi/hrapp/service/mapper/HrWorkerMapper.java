package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.HrWorker;
import pwr.zpi.hrapp.persistance.entities.HrWorkerEntity;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;

@Mapper(uses = {PersonMapper.class, EntityFactory.class})
public abstract class HrWorkerMapper implements BaseMapper<HrWorker, HrWorkerEntity> {
  @Autowired private LoginRepository loginRepository;

  @Mapping(source = "login.id", target = "loginId")
  @Override
  public abstract HrWorker mapToDto(HrWorkerEntity entity);

  @Mapping(source = "loginId", target = "login")
  @Override
  public abstract HrWorkerEntity mapToEntity(HrWorker dto);

  protected LoginEntity loginEntityFromId(Integer id) {
    return loginRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
