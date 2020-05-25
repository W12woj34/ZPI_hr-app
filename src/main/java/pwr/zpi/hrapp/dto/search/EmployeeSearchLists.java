package pwr.zpi.hrapp.dto.search;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pwr.zpi.hrapp.validation.ValidList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchLists {
  @Valid ValidList<SearchSkillLevel> searchSkillLevels;
  @Valid ValidList<SearchLanguageKnowledge> searchLanguageKnowledges;
}
