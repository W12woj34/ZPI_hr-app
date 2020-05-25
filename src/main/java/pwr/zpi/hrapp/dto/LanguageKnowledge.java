package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageKnowledge extends BaseGeneratedIdDto<Integer> {
  @NotNull private Integer employeeId;
  @NotNull private Language language;
  @NotNull private LanguageLevel languageLevel;
}
