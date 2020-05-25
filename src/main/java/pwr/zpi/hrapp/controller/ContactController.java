package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Contact;
import pwr.zpi.hrapp.service.ContactService;

@RestController
@RequestMapping(RestMappings.CONTACT)
public class ContactController extends BaseRestController<Contact, Integer> {

  public ContactController(ContactService service) {
    super(service);
  }
}
