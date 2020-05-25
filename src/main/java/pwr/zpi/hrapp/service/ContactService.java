package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Contact;
import pwr.zpi.hrapp.persistance.entities.ContactEntity;

public interface ContactService extends SpecificationCrudService<Contact, ContactEntity, Integer> {}
