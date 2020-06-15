package pwr.zpi.hrapp.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import pwr.zpi.hrapp.validation.groups.OnCreate;

@Data
@NoArgsConstructor
public class Employee extends Person {
  @NotNull(groups = OnCreate.class)
  private Integer loginId;
}
