package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

@Repository
public interface WorkingEmployeeRepository
    extends JpaRepository<WorkingEmployeeEntity, Integer>,
        JpaSpecificationExecutor<WorkingEmployeeEntity> {}
