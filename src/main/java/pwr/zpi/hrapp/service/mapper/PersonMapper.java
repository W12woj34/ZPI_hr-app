package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Person;
import pwr.zpi.hrapp.persistance.entities.PersonEntity;

@Mapper(uses = EntityFactory.class)
public interface PersonMapper extends BaseMapper<Person, PersonEntity> {}
