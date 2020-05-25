package pwr.zpi.hrapp.service.implementations;

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

    Collection<SimpleGrantedAuthority> roles = new LinkedList<>();

    if (isEmployee) {
      roles.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_EMPLOYEE));
    }
    if (isHRWorker) {
      roles.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_HR));
    }
    if (isAdmin) {
      roles.add(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_ADMIN));
    }

    return new User(user.getEmail(), user.getPassword(), roles);
  }
}
