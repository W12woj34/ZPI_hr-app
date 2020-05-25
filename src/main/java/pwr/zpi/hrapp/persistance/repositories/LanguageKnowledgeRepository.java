package pwr.zpi.hrapp.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;

@Repository
public interface LanguageKnowledgeRepository
    extends JpaRepository<LanguageKnowledgeEntity, Integer>,
        JpaSpecificationExecutor<LanguageKnowledgeEntity> {}
