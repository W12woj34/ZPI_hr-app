package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Repository
public interface TerminatedEmployeeRepository
    extends JpaRepository<TerminatedEmployeeEntity, Integer>,
        JpaSpecificationExecutor<TerminatedEmployeeEntity> {}
