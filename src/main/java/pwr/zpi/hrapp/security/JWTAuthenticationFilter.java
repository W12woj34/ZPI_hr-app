package pwr.zpi.hrapp.security;

import static pwr.zpi.hrapp.security.SecurityConstants.EXPIRATION_TIME;
import static pwr.zpi.hrapp.security.SecurityConstants.EXPIRATION_TIME_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_AUTH;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.SECRET_AUTH;
import static pwr.zpi.hrapp.security.SecurityConstants.SECRET_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.TOKEN_PREFIX;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pwr.zpi.hrapp.persistance.entities.LoginEntity;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      LoginEntity creds = new ObjectMapper().readValue(request.getInputStream(), LoginEntity.class);

      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              creds.getEmail(), creds.getPassword(), new ArrayList<>()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication auth) {

    long currentTimeMillis = System.currentTimeMillis();
    String tokenAuth =
        Jwts.builder()
            .setSubject(((User) auth.getPrincipal()).getUsername())
            .claim(
                "roles",
                auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(";")))
            .setIssuedAt(new Date(currentTimeMillis))
            .setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET_AUTH.getBytes())
            .compact();

    String tokenRefresh =
        Jwts.builder()
            .setSubject(((User) auth.getPrincipal()).getUsername())
            .claim(
                "roles",
                auth.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(";")))
            .setIssuedAt(new Date(currentTimeMillis))
            .setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME_REFRESH))
            .signWith(SignatureAlgorithm.HS512, SECRET_REFRESH.getBytes())
            .compact();

    response.addHeader(HEADER_STRING_AUTH, TOKEN_PREFIX + tokenAuth);
    response.addHeader(HEADER_STRING_REFRESH, tokenRefresh);
  }
}
