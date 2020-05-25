package pwr.zpi.hrapp.specifications;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.persistance.entities.ApplicantEntity;

@And({
  @Spec(path = "firstName", params = "firstName", spec = Like.class),
  @Spec(path = "lastName", params = "lastName", spec = Like.class),
  @Spec(path = "position", params = "position", spec = Like.class),
  @Spec(path = "initialAssessment", params = "initialAssessment", spec = GreaterThanOrEqual.class),
  @Spec(
      path = "birthdate",
      params = {"birthdateFrom", "birthdateTo"},
      spec = Between.class),
  @Spec(
      path = "scheduledMeeting",
      params = {"scheduledMeetingFrom", "scheduledMeetingTo"},
      spec = Between.class)
})
public interface ApplicantSpecification extends Specification<ApplicantEntity> {}
