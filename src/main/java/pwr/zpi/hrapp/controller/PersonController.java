package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Person;
import pwr.zpi.hrapp.service.PersonService;

@RestController
@RequestMapping(RestMappings.PERSON)
public class PersonController extends BaseRestController<Person, Integer> {

  public PersonController(PersonService service) {
    super(service);
  }
}
