package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Contact;
import pwr.zpi.hrapp.persistance.entities.ContactEntity;
import pwr.zpi.hrapp.persistance.repositories.ContactRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.ContactService;
import pwr.zpi.hrapp.service.mapper.ContactMapper;

@Service
public class ContactServiceImpl
    extends BaseSpecificationCrudService<Contact, ContactEntity, Integer, ContactRepository>
    implements ContactService {

  public ContactServiceImpl(ContactRepository repository, ContactMapper mapper) {
    super(repository, mapper);
  }
}
