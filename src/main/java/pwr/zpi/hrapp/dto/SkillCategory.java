package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillCategory extends BaseGeneratedIdDto<Integer> {
  @NotNull
  @Size(max = 255)
  private String name;
}
