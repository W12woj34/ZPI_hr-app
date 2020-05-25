package pwr.zpi.hrapp.service.implementations;

import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.HrWorker;
import pwr.zpi.hrapp.persistance.entities.HrWorkerEntity;
import pwr.zpi.hrapp.persistance.repositories.HrWorkerRepository;
import pwr.zpi.hrapp.service.BaseSpecificationCrudService;
import pwr.zpi.hrapp.service.HrWorkerService;
import pwr.zpi.hrapp.service.mapper.HrWorkerMapper;

@Service
public class HrWorkerServiceImpl
    extends BaseSpecificationCrudService<HrWorker, HrWorkerEntity, Integer, HrWorkerRepository>
    implements HrWorkerService {

  public HrWorkerServiceImpl(HrWorkerRepository repository, HrWorkerMapper mapper) {
    super(repository, mapper);
  }
}
