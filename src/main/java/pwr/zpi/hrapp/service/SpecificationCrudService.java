package pwr.zpi.hrapp.service;

import java.io.Serializable;
import org.springframework.data.domain.Persistable;
import pwr.zpi.hrapp.dto.PersistableDto;

public interface SpecificationCrudService<
        T extends PersistableDto<ID>, U extends Persistable<ID>, ID extends Serializable>
    extends CrudService<T, ID>, SpecificationReadService<T, U, ID> {}
