package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.Experience;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;

@Mapper(uses = {EntityFactory.class})
public abstract class ExperienceMapper implements BaseMapper<Experience, ExperienceEntity> {
  @Autowired private EmployeeRepository employeeRepository;

  @Mapping(target = "employeeId", source = "employee.id")
  @Override
  public abstract Experience mapToDto(ExperienceEntity entity);

  @Mapping(target = "employee", source = "employeeId")
  @Override
  public abstract ExperienceEntity mapToEntity(Experience dto);

  protected EmployeeEntity employeeEntityFromId(Integer id) {
    return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
