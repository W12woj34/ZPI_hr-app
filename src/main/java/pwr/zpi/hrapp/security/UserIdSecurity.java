package pwr.zpi.hrapp.security;

import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_ADMIN;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_HR;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_PREFIX;

import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;
import pwr.zpi.hrapp.persistance.entities.ExperienceEntity;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;
import pwr.zpi.hrapp.persistance.repositories.ContactRepository;
import pwr.zpi.hrapp.persistance.repositories.EducationRepository;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;
import pwr.zpi.hrapp.persistance.repositories.ExperienceRepository;
import pwr.zpi.hrapp.persistance.repositories.HrWorkerRepository;
import pwr.zpi.hrapp.persistance.repositories.LanguageKnowledgeRepository;
import pwr.zpi.hrapp.persistance.repositories.LanguageRepository;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;
import pwr.zpi.hrapp.persistance.repositories.PersonRepository;
import pwr.zpi.hrapp.persistance.repositories.SkillLevelRepository;

@Component("userSecurity")
public class UserIdSecurity {

  LoginRepository repositoryLogin;
  EmployeeRepository repositoryEmployee;
  HrWorkerRepository repositoryHrWorker;
  LanguageRepository languageRepository;
  ContactRepository contactRepository;
  EducationRepository educationRepository;
  ExperienceRepository experienceRepository;
  LanguageKnowledgeRepository languageKnowledgeRepository;
  PersonRepository personRepository;
  SkillLevelRepository skillLevelRepository;

  public UserIdSecurity(
      LoginRepository repositoryLogin,
      EmployeeRepository repositoryEmployee,
      HrWorkerRepository repositoryHrWorker,
      LanguageRepository languageRepository,
      ContactRepository contactRepository,
      EducationRepository educationRepository,
      ExperienceRepository experienceRepository,
      LanguageKnowledgeRepository languageKnowledgeRepository,
      PersonRepository personRepository,
      SkillLevelRepository skillLevelRepository) {
    this.repositoryLogin = repositoryLogin;
    this.repositoryEmployee = repositoryEmployee;
    this.repositoryHrWorker = repositoryHrWorker;
    this.languageRepository = languageRepository;
    this.contactRepository = contactRepository;
    this.educationRepository = educationRepository;
    this.experienceRepository = experienceRepository;
    this.languageKnowledgeRepository = languageKnowledgeRepository;
    this.personRepository = personRepository;
    this.skillLevelRepository = skillLevelRepository;
  }

  public boolean hasUserIdOrHRGet(
      Authentication authentication, String requestedId, HttpServletRequest request) {

    if (checkIfHR(authentication)) {
      return true;
    }

    int id;
    try {
      String idString = request.getParameter("employeeId");
      if (idString != null) {
        id = Integer.parseInt(idString);
      } else {
        id = Integer.parseInt(requestedId);
      }
    } catch (NumberFormatException e) {
      return false;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    return employeeId == id;
  }

  public boolean hasUserIdOrHRContact(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    return Objects.equals(employeeId, requestedId);
  }

  public boolean hasUserIdOrHREducation(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    Optional<EducationEntity> educationEntity = educationRepository.findById(requestedId);
    if (educationEntity.isEmpty()) {
      return false;
    }
    return Objects.equals(educationEntity.get().getEmployee().getId(), employeeId);
  }

  public boolean hasUserIdOrHRExperience(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    Optional<ExperienceEntity> experienceEntity = experienceRepository.findById(requestedId);
    if (experienceEntity.isEmpty()) {
      return false;
    }
    return Objects.equals(experienceEntity.get().getEmployee().getId(), employeeId);
  }

  public boolean hasUserIdOrHRLanguage(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    Optional<LanguageKnowledgeEntity> languageKnowledgeEntity =
        languageKnowledgeRepository.findById(requestedId);
    if (languageKnowledgeEntity.isEmpty()) {
      return false;
    }
    return Objects.equals(languageKnowledgeEntity.get().getEmployee().getId(), employeeId);
  }

  public boolean hasUserIdOrHRPerson(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    return Objects.equals(employeeId, requestedId);
  }

  public boolean hasUserIdOrHRSkill(Authentication authentication, Integer requestedId) {

    if (checkIfHR(authentication)) {
      return true;
    }

    Integer employeeId = getEmployeeId(authentication);
    if (employeeId == null) {
      return false;
    }

    Optional<SkillLevelEntity> skillLevelEntity = skillLevelRepository.findById(requestedId);
    if (skillLevelEntity.isEmpty()) {
      return false;
    }
    return Objects.equals(skillLevelEntity.get().getEmployee().getId(), employeeId);
  }

  public boolean hasUserIdOrAdminPass(Authentication authentication, Integer requestedId) {

    if (authentication.getAuthorities().stream()
        .map(Object::toString)
        .anyMatch(s -> s.contains(ROLE_PREFIX + ROLE_ADMIN))) {
      return true;
    }

    Integer loginId = repositoryLogin.findByEmail(authentication.getPrincipal().toString()).getId();

    if (loginId == null) {
      return false;
    }

    return Objects.equals(loginId, requestedId);
  }

  private boolean checkIfHR(Authentication authentication) {

    return authentication.getAuthorities().stream()
        .map(Object::toString)
        .anyMatch(s -> s.contains(ROLE_PREFIX + ROLE_HR));
  }

  private Integer getEmployeeId(Authentication authentication) {
    Integer loginId = repositoryLogin.findByEmail(authentication.getPrincipal().toString()).getId();

    if (loginId == null) {
      return null;
    }
    EmployeeEntity employeeEntity = repositoryEmployee.findByLogin_id(loginId);

    if (employeeEntity == null) {
      return null;
    }

    return employeeEntity.getId();
  }
}
