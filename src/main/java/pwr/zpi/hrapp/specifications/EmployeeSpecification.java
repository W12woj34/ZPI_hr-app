package pwr.zpi.hrapp.specifications;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Joins;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import pwr.zpi.hrapp.persistance.entities.EmployeeEntity;

@Joins({
  @Join(path = "contact", alias = "contact"),
})
@And({
  @Spec(path = "contact.email", params = "contactEmail", spec = Like.class),
  @Spec(path = "contact.mobile", params = "contactMobile", spec = Like.class),
  @Spec(path = "firstName", params = "firstName", spec = Like.class),
  @Spec(path = "lastName", params = "lastName", spec = Like.class),
  @Spec(
      path = "birthdate",
      params = {"birthdateFrom", "birthdateTo"},
      spec = Between.class)
})
public interface EmployeeSpecification<T extends EmployeeEntity> extends Specification<T> {}
