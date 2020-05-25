package pwr.zpi.hrapp.specifications;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import pwr.zpi.hrapp.persistance.entities.TerminatedEmployeeEntity;

@Spec(
    path = "thisIsAWorkaroundBecauseSpecCantBeEmptyEvenThoughExtendingAnotherSpec",
    spec = Like.class)
public interface TerminatedEmployeeSpecification
    extends EmployeeSpecification<TerminatedEmployeeEntity> {}
