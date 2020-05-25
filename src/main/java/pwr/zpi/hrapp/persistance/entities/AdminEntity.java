package pwr.zpi.hrapp.persistance.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Admin")
@Data
@NoArgsConstructor
public class AdminEntity extends PersonEntity {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "login_id")
  private LoginEntity login;
}
