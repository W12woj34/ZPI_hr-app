package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education extends BaseGeneratedIdDto<Integer> {
  @Size(max = 255)
  private String institution;

  @Size(max = 255)
  private String fieldOfStudy;

  @Size(max = 255)
  private String educationPeriod;

  @Size(max = 255)
  private String degree;

  @NotNull private Integer employeeId;
}
