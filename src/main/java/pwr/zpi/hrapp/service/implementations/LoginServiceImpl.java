package pwr.zpi.hrapp.service.implementations;

import static pwr.zpi.hrapp.security.SecurityConstants.EXPIRATION_TIME_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.SECRET_REFRESH;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pwr.zpi.hrapp.dto.Login;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;
import pwr.zpi.hrapp.persistance.repositories.LoginRepository;
import pwr.zpi.hrapp.service.BaseCrudService;
import pwr.zpi.hrapp.service.LoginService;
import pwr.zpi.hrapp.service.mapper.BaseMapper;

@Service
public class LoginServiceImpl extends BaseCrudService<Login, LoginEntity, Integer, LoginRepository>
    implements LoginService {

  private LoginRepository loginRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public LoginServiceImpl(
      LoginRepository repository,
      BaseMapper<Login, LoginEntity> mapper,
      LoginRepository loginRepository,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    super(repository, mapper);
    this.loginRepository = loginRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public Integer register(String email, String password) {
    LoginEntity user = new LoginEntity();
    user.setEmail(email);
    user.setPassword(password);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    return loginRepository.save(user).getId();
  }

  @Override
  public String refresh(String refreshToken) {

    Jws<Claims> claimsJws =
        Jwts.parser().setSigningKey(SECRET_REFRESH.getBytes()).parseClaimsJws(refreshToken);

    long currentTimeMillis = System.currentTimeMillis();

    return Jwts.builder()
        .setSubject(claimsJws.getSignature())
        .claim("roles", claimsJws.getBody().get("roles").toString())
        .setIssuedAt(new Date(currentTimeMillis))
        .setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME_REFRESH))
        .signWith(SignatureAlgorithm.HS512, SECRET_REFRESH.getBytes())
        .compact();
  }
}
