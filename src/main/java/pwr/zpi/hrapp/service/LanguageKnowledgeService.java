package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.LanguageKnowledge;
import pwr.zpi.hrapp.persistance.entities.LanguageKnowledgeEntity;

public interface LanguageKnowledgeService
    extends SpecificationCrudService<LanguageKnowledge, LanguageKnowledgeEntity, Integer> {}
