package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.HrWorkerEntity;

@Repository
public interface HrWorkerRepository
    extends JpaRepository<HrWorkerEntity, Integer>, JpaSpecificationExecutor<HrWorkerEntity> {}
