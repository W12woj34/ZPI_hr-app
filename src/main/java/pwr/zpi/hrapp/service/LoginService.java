package pwr.zpi.hrapp.service;

import pwr.zpi.hrapp.dto.Login;

public interface LoginService extends CrudService<Login, Integer> {

  Integer register(String email, String password);

  String refresh(String refreshToken);
}
