package pwr.zpi.hrapp.service.implementations;

import static pwr.zpi.hrapp.security.SecurityConstants.LOGIN_PREFIX;
import static pwr.zpi.hrapp.security.SecurityConstants.PERSON_PREFIX;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_ADMIN;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_EMPLOYEE;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_HR;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_PREFIX;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.AdminRepository;
import pwr.zpi.hrapp.persistance.repositories.EmployeeRepository;
import pwr.zpi.hrapp.persistance.repositories.HrWorkerRepository;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private LoginRepository loginRepository;
  private HrWorkerRepository hrWorkerRepository;
  private AdminRepository adminRepository;
  private EmployeeRepository employeeRepository;

  public UserDetailsServiceImpl(
      LoginRepository loginRepository,
      HrWorkerRepository hrWorkerRepository,
      AdminRepository adminRepository,
      EmployeeRepository employeeRepository) {

    this.loginRepository = loginRepository;
    this.hrWorkerRepository = hrWorkerRepository;
    this.adminRepository = adminRepository;
    this.employeeRepository = employeeRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    LoginEntity user = loginRepository.findByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException(email);
    }

    boolean isHRWorker =
        hrWorkerRepository.findById(Objects.requireNonNull(user.getId())).isPresent();

    boolean isAdmin = adminRepository.findById(Objects.requireNonNull(user.getId())).isPresent();

    boolean isEmployee =
        employeeRepository.findById(Objects.requireNonNull(user.getId())).isPresent();

    Collection<SimpleGrantedAuthority> authorities = new LinkedList<>();

    authorities.add(new SimpleGrantedAuthority(LOGIN_PREFIX + user.getId().toString()));

    if (isEmployee) {
      authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_EMPLOYEE));
      authorities.add(
          new SimpleGrantedAuthority(
              (PERSON_PREFIX + employeeRepository.findByLogin_id(user.getId()).getId())));
    }
    if (isHRWorker) {
      authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_HR));
      authorities.add(
          new SimpleGrantedAuthority(
              (PERSON_PREFIX + hrWorkerRepository.findByLogin_id(user.getId()).getId())));
    }
    if (isAdmin) {
      authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_ADMIN));
      authorities.add(
          new SimpleGrantedAuthority(
              (PERSON_PREFIX + adminRepository.findByLogin_id(user.getId()).getId())));
    }

    return new User(user.getEmail(), user.getPassword(), authorities);
  }
}
