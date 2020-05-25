package pwr.zpi.hrapp.security;

import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;

@Component("userSecurity")
public class UserIdSecurity {

  LoginRepository repository;

  public UserIdSecurity(LoginRepository repository) {
    this.repository = repository;
  }

  public boolean hasUserId(Authentication authentication, Integer userId) {

    Optional<LoginEntity> user = repository.findById(userId);

    return user.filter(
            loginEntity -> authentication.getPrincipal().toString().equals(loginEntity.getEmail()))
        .isPresent();
  }
}
