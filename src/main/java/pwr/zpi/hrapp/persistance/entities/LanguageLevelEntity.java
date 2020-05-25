package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "Language_Level")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageLevelEntity extends AbstractPersistable<Integer> {

  private String level;
}
