package pwr.zpi.hrapp.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant extends Person {
  @Size(max = 255)
  private String position;

  private Integer initialAssessment;

  @Size(max = 2000)
  private String comments;

  @Future private LocalDateTime scheduledMeeting;
}
