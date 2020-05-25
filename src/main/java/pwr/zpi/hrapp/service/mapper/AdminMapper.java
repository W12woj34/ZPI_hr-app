package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.Admin;
import pwr.zpi.hrapp.persistance.entities.AdminEntity;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;

@Mapper(uses = {PersonMapper.class, EntityFactory.class})
public abstract class AdminMapper implements BaseMapper<Admin, AdminEntity> {
  @Autowired LoginRepository loginRepository;

  @Mapping(target = "loginId", source = "login.id")
  @Override
  public abstract Admin mapToDto(AdminEntity entity);

  @Override
  @Mapping(target = "login", source = "loginId")
  public abstract AdminEntity mapToEntity(Admin dto);

  protected LoginEntity loginEntityFromId(Integer id) {
    return loginRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
