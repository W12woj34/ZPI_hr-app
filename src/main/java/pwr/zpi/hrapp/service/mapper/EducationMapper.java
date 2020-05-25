package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.Education;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;

@Mapper(uses = {EntityFactory.class})
public abstract class EducationMapper implements BaseMapper<Education, EducationEntity> {
  @Autowired private EmployeeRepository employeeRepository;

  @Mapping(target = "employeeId", source = "employee.id")
  @Override
  public abstract Education mapToDto(EducationEntity entity);

  @Mapping(target = "employee", source = "employeeId")
  @Override
  public abstract EducationEntity mapToEntity(Education dto);

  protected EmployeeEntity employeeEntityFromId(Integer id) {
    return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
