package pwr.zpi.hrapp.dto.search;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLanguageKnowledge implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull private Integer languageId;
  @NotNull private String level;
}
