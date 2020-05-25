package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.EducationEntity;

@Repository
public interface EducationRepository
    extends JpaRepository<EducationEntity, Integer>, JpaSpecificationExecutor<EducationEntity> {}
