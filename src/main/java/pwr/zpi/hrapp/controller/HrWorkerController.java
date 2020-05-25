package pwr.zpi.hrapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.HrWorker;
import pwr.zpi.hrapp.service.HrWorkerService;

@RestController
@RequestMapping(RestMappings.HR_WORKER)
public class HrWorkerController extends BaseRestController<HrWorker, Integer> {

  public HrWorkerController(HrWorkerService service) {
    super(service);
  }
}
