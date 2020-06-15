package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

  AdminEntity findByLogin_id(int login_id);
}
