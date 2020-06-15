package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.Employee;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;

@Mapper(uses = PersonMapper.class)
public abstract class EmployeeMapper implements BaseMapper<Employee, EmployeeEntity> {
  @Autowired private LoginRepository loginRepository;

  @Mapping(source = "login.id", target = "loginId")
  @Override
  public abstract Employee mapToDto(EmployeeEntity entity);

  @Mapping(source = "loginId", target = "login")
  @Override
  public abstract EmployeeEntity mapToEntity(Employee dto);

  protected LoginEntity loginEntityFromId(Integer id) {
    return loginRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
