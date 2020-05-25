package pwr.zpi.hrapp.persistance.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Applicant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantEntity extends PersonEntity {

  private String position;

  @Column(name = "initial_assessment")
  private Integer initialAssessment;

  private String comments;

  @Column(name = "scheduled_meeting")
  private LocalDateTime scheduledMeeting;
}
