package pwr.zpi.hrapp.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseGeneratedIdDto<Integer> {

  @NotNull
  @Size(max = 255)
  private String firstName;

  @NotNull
  @Size(max = 255)
  private String lastName;

  @Past private LocalDate birthdate;
}
