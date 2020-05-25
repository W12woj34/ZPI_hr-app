package pwr.zpi.hrapp.controller;

import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_AUTH;
import static pwr.zpi.hrapp.security.SecurityConstants.TOKEN_PREFIX;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pwr.zpi.hrapp.dto.Login;
import pwr.zpi.hrapp.service.LoginService;

@RestController
@RequestMapping(RestMappings.LOGIN)
public class LoginController extends BaseRestGetController<Login, Integer> {

  LoginService service;

  public LoginController(LoginService service) {
    super(service);
    this.service = service;
  }

  @PostMapping(RestMappings.SIGN_UP)
  public ResponseEntity<Integer> signUp(@RequestParam String email, @RequestParam String password) {
    return ResponseEntity.ok(service.register(email, password));
  }

  @PostMapping("/refresh")
  public void refresh(@RequestParam String refreshToken, HttpServletResponse response) {
    response.addHeader(HEADER_STRING_AUTH, TOKEN_PREFIX + service.refresh(refreshToken));
  }
}
