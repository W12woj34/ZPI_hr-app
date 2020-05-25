package pwr.zpi.hrapp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillLevel extends BaseGeneratedIdDto<Integer> {

  @NotNull
  @Min(1)
  @Max(5)
  private Integer level;

  @NotNull private Integer employeeId;
  @NotNull private Skill skill;
}
