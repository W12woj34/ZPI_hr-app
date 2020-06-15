package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

@Repository
public interface WorkingEmployeeRepository
    extends JpaRepository<WorkingEmployeeEntity, Integer>,
        JpaSpecificationExecutor<WorkingEmployeeEntity> {

  @Query(value = "DELETE FROM Working_Employee WHERE id=:id", nativeQuery = true)
  @Modifying
  @Transactional
  void deleteWithoutInheritance(int id);
}
