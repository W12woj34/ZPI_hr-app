package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Repository
public interface TerminatedEmployeeRepository
    extends JpaRepository<TerminatedEmployeeEntity, Integer>,
        JpaSpecificationExecutor<TerminatedEmployeeEntity> {

  @Query(value = "INSERT INTO Terminated_Employee(id) VALUES (:id)", nativeQuery = true)
  @Modifying
  @Transactional
  void insertWithoutInheritance(int id);
}
