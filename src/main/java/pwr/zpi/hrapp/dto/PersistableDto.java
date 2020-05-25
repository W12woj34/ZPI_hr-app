package pwr.zpi.hrapp.dto;

import java.io.Serializable;

public interface PersistableDto<ID extends Serializable> {

  ID getId();

  void setId(ID id);
}
