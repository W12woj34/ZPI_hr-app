package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pwr.zpi.hrapp.validation.groups.OnCreate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrWorker extends Person {
  @NotNull(groups = OnCreate.class)
  private Integer loginId;
}
