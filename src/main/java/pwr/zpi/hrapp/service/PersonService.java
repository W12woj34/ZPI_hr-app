package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Person;
import pwr.zpi.hrapp.persistance.entities.PersonEntity;

public interface PersonService extends SpecificationCrudService<Person, PersonEntity, Integer> {}
