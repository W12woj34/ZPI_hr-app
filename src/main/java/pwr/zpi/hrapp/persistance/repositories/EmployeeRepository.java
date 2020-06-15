package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository
    extends JpaRepository<EmployeeEntity, Integer>, JpaSpecificationExecutor<EmployeeEntity> {

  EmployeeEntity findByLogin_id(int login_id);
}
