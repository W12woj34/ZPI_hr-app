package pwr.zpi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.validation.constraints.Null;
import lombok.Data;
import pwr.zpi.hrapp.validation.groups.OnCreate;

@Data
@JsonPropertyOrder({"id"})
public abstract class BaseGeneratedIdDto<ID extends Serializable> implements PersistableDto<ID> {

  @Null(groups = {OnCreate.class})
  private ID id;
}
