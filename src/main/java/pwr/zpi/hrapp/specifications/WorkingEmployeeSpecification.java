package pwr.zpi.hrapp.specifications;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import pwr.zpi.hrapp.persistance.entities.WorkingEmployeeEntity;

@Spec(
    path = "thisIsAWorkaroundBecauseSpecCantBeEmptyEvenThoughExtendingAnotherSpec",
    spec = Like.class)
public interface WorkingEmployeeSpecification
    extends EmployeeSpecification<WorkingEmployeeEntity> {}
