package pwr.zpi.hrapp.specifications;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Spec(
    path = "nextDateContact",
    params = {"nextDateContactFrom", "nextDateContactTo"},
    spec = Between.class)
public interface TerminatedEmployeeSpecification
    extends EmployeeSpecification<TerminatedEmployeeEntity> {}
