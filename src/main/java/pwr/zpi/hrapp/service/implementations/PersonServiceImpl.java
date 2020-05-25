package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Person;
import pwr.zpi.hrapp.persistance.entities.PersonEntity;
import pwr.zpi.hrapp.persistance.repositories.PersonRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.PersonService;
import pwr.zpi.hrapp.service.mapper.PersonMapper;

@Service
public class PersonServiceImpl
    extends BaseSpecificationCrudService<Person, PersonEntity, Integer, PersonRepository>
    implements PersonService {

  public PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
    super(repository, mapper);
  }
}
