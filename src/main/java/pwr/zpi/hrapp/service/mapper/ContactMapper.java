package pwr.zpi.hrapp.service.mapper;

import org.mapstruct.Mapper;
import pwr.zpi.hrapp.dto.Contact;
import pwr.zpi.hrapp.persistance.entities.ContactEntity;

@Mapper(uses = EntityFactory.class)
public interface ContactMapper extends BaseMapper<Contact, ContactEntity> {}
