package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.SkillLevel;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.SkillEntity;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;
import pwr.zpi.hrapp.persistance.repositories.SkillRepository;

@Mapper
public abstract class SkillLevelMapper implements BaseMapper<SkillLevel, SkillLevelEntity> {
  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private SkillRepository skillRepository;

  @Override
  @Mapping(target = "employeeId", source = "employee.id")
  public abstract SkillLevel mapToDto(SkillLevelEntity entity);

  @Override
  @Mapping(target = "employee", source = "employeeId")
  @Mapping(target = "skill", source = "skill.id")
  public abstract SkillLevelEntity mapToEntity(SkillLevel dto);

  protected EmployeeEntity employeeEntityFromId(Integer id) {
    return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  protected SkillEntity skillEntityFromId(Integer id) {
    return skillRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
