package pwr.zpi.hrapp.dto;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends BaseInheritedIdDto<Integer> {
  @Size(max = 255)
  private String mobile;

  @Size(max = 255)
  private String email;

  @Size(max = 255)
  private String git;

  @Size(max = 255)
  private String linkedin;

  @Size(max = 1024)
  private String other;
}
