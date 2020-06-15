package pwr.zpi.hrapp.dto.search;

import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchLists {
  private List<@Valid SearchSkillLevel> searchSkillLevels = new LinkedList<>();
  private List<@Valid SearchLanguageKnowledge> searchLanguageKnowledges = new LinkedList<>();
}
