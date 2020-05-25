package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.SkillLevelEntity;

@Repository
public interface SkillLevelRepository
    extends JpaRepository<SkillLevelEntity, Integer>, JpaSpecificationExecutor<SkillLevelEntity> {}
