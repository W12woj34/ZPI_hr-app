package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.SkillEntity;

@Repository
public interface SkillRepository
    extends JpaRepository<SkillEntity, Integer>, JpaSpecificationExecutor<SkillEntity> {}
