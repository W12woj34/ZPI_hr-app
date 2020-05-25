package pwr.zpi.hrapp.service.mapper;

import javax.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import pwr.zpi.hrapp.dto.LanguageKnowledge;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.LanguageEntity;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;
import pwr.zpi.hrapp.persistance.entities.LanguageLevelEntity;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;
import pwr.zpi.hrapp.persistance.repositories.LanguageLevelRepository;
import pwr.zpi.hrapp.persistance.repositories.LanguageRepository;

@Mapper(uses = {EntityFactory.class})
public abstract class LanguageKnowledgeMapper
    implements BaseMapper<LanguageKnowledge, LanguageKnowledgeEntity> {
  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private LanguageRepository languageRepository;
  @Autowired private LanguageLevelRepository languageLevelRepository;

  @Override
  @Mapping(target = "employeeId", source = "employee.id")
  public abstract LanguageKnowledge mapToDto(LanguageKnowledgeEntity entity);

  @Override
  @Mapping(target = "employee", source = "employeeId")
  @Mapping(target = "language", source = "language.id")
  @Mapping(target = "languageLevel", source = "languageLevel.id")
  public abstract LanguageKnowledgeEntity mapToEntity(LanguageKnowledge dto);

  protected EmployeeEntity employeeEntityFromId(Integer id) {
    return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  protected LanguageEntity languageEntityFromId(Integer id) {
    return languageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  protected LanguageLevelEntity languageLevelEntityFromId(Integer id) {
    return languageLevelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }
}
