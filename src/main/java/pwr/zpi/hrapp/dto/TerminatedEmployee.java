package pwr.zpi.hrapp.dto;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TerminatedEmployee extends Employee {
  @Size(max = 255)
  private String availability;

  @FutureOrPresent private LocalDate nextDateContact;
}
