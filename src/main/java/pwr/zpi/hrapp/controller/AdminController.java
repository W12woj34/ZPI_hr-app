package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Admin;
import pwr.zpi.hrapp.service.AdminService;

@RestController
@RequestMapping(RestMappings.ADMIN)
public class AdminController extends BaseRestController<Admin, Integer> {

  public AdminController(AdminService service) {
    super(service);
  }
}
