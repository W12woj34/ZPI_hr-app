package pwr.zpi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;
import pwr.zpi.hrapp.validation.groups.OnCreate;

@Data
@JsonPropertyOrder({"id"})
public abstract class BaseInheritedIdDto<ID extends Serializable> implements PersistableDto<ID> {

  @NotNull(groups = {OnCreate.class})
  private ID id;
}
