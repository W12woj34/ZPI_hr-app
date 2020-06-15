package pwr.zpi.hrapp.controller;

import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_AUTH;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.PASSWORD_CHANGE_PASSWORD_MISMATCH;
import static pwr.zpi.hrapp.security.SecurityConstants.PASSWORD_CHANGE_USER_NOT_EXISTS;
import static pwr.zpi.hrapp.security.SecurityConstants.TOKEN_PREFIX;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Login;
import pwr.zpi.hrapp.service.LoginService;

@RestController
@RequestMapping(RestMappings.LOGIN)
public class LoginController extends BaseRestGetController<Login, Integer> {

  private final LoginService service;

  public LoginController(LoginService service) {
    super(service);
    this.service = service;
  }

  @PostMapping(RestMappings.SIGN_UP)
  public ResponseEntity<Integer> signUp(@RequestParam String email, @RequestParam String password) {
    return ResponseEntity.ok(service.register(email, password));
  }

  @PostMapping(RestMappings.REFRESH_TOKEN)
  public void refresh( HttpServletRequest request, HttpServletResponse response) {
    response.addHeader(HEADER_STRING_AUTH, TOKEN_PREFIX + service.refresh(request.getHeader(HEADER_STRING_REFRESH)));
  }

  @PutMapping(RestMappings.CHANGE_PASSWORD + RestMappings.ID)
  public ResponseEntity<Void> changePassword(
      @PathVariable Integer id,
      @RequestParam String oldPassword,
      @RequestParam String newPassword) {

    int code = service.changePassword(id, oldPassword, newPassword);
    if (code == PASSWORD_CHANGE_USER_NOT_EXISTS) {
      return ResponseEntity.status(404).build();
    } else if (code == PASSWORD_CHANGE_PASSWORD_MISMATCH) {
      return ResponseEntity.status(409).build();
    } else {
      return ResponseEntity.ok().build();
    }
  }
}
