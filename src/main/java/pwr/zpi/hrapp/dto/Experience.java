package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience extends BaseGeneratedIdDto<Integer> {
  @Size(max = 255)
  private String companyName;

  @Size(max = 255)
  private String position;

  @Size(max = 255)
  private String workingPeriod;

  @NotNull private Integer employeeId;
}
