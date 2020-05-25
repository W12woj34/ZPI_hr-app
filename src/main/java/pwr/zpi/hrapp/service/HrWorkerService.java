package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.HrWorker;
import pwr.zpi.hrapp.persistance.entities.HrWorkerEntity;

public interface HrWorkerService
    extends SpecificationCrudService<HrWorker, HrWorkerEntity, Integer> {}
