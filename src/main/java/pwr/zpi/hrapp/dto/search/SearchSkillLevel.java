package pwr.zpi.hrapp.dto.search;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchSkillLevel implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull private Integer skillId;

  @NotNull
  @Min(1)
  @Max(5)
  private Integer level;
}
