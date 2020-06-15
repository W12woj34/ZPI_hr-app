package pwr.zpi.hrapp.security;

import static pwr.zpi.hrapp.controller.RestMappings.ADMIN;
import static pwr.zpi.hrapp.controller.RestMappings.CHANGE_PASSWORD;
import static pwr.zpi.hrapp.controller.RestMappings.CONTACT;
import static pwr.zpi.hrapp.controller.RestMappings.CV_FILES;
import static pwr.zpi.hrapp.controller.RestMappings.EDUCATION;
import static pwr.zpi.hrapp.controller.RestMappings.EMPLOYEE;
import static pwr.zpi.hrapp.controller.RestMappings.EXPERIENCE;
import static pwr.zpi.hrapp.controller.RestMappings.HR_WORKER;
import static pwr.zpi.hrapp.controller.RestMappings.LANGUAGE;
import static pwr.zpi.hrapp.controller.RestMappings.LANGUAGE_KNOWLEDGE;
import static pwr.zpi.hrapp.controller.RestMappings.LANGUAGE_LEVEL;
import static pwr.zpi.hrapp.controller.RestMappings.LOGIN;
import static pwr.zpi.hrapp.controller.RestMappings.PERSON;
import static pwr.zpi.hrapp.controller.RestMappings.SKILL;
import static pwr.zpi.hrapp.controller.RestMappings.SKILL_CATEGORY;
import static pwr.zpi.hrapp.controller.RestMappings.SKILL_LEVEL;
import static pwr.zpi.hrapp.controller.RestMappings.TERMINATED_EMPLOYEE;
import static pwr.zpi.hrapp.controller.RestMappings.WORKING_EMPLOYEE;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_AUTH;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_ID;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_PERSON;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_REFRESH;
import static pwr.zpi.hrapp.security.SecurityConstants.HEADER_STRING_TYPE;
import static pwr.zpi.hrapp.security.SecurityConstants.REFRESH_TOKEN_URL;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_ADMIN;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_EMPLOYEE;
import static pwr.zpi.hrapp.security.SecurityConstants.ROLE_HR;
import static pwr.zpi.hrapp.security.SecurityConstants.SIGN_UP_URL;

import java.util.Arrays;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import pwr.zpi.hrapp.service.implementations.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
  private UserDetailsServiceImpl userDetailsService;
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private HttpServletRequest request;

  public WebSecurity(
      UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userDetailsService = userDetailsService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, SIGN_UP_URL, REFRESH_TOKEN_URL)
        .permitAll()
        .antMatchers(ADMIN + "/**")
        .hasRole(ROLE_ADMIN)
        .antMatchers(
            HttpMethod.DELETE,
            HR_WORKER + "/**",
            TERMINATED_EMPLOYEE + "/**",
            WORKING_EMPLOYEE + "/**")
        .hasRole(ROLE_ADMIN)
        .antMatchers(
            HttpMethod.POST,
            HR_WORKER + "/**",
            TERMINATED_EMPLOYEE + "/**",
            WORKING_EMPLOYEE + "/**")
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(CV_FILES + "/**")
        .hasRole(ROLE_HR)
        .antMatchers(
            HttpMethod.GET,
            LANGUAGE + "/**",
            LANGUAGE_LEVEL + "/**",
            SKILL_CATEGORY + "/**",
            SKILL + "/**")
        .authenticated()
        .antMatchers(LOGIN + CHANGE_PASSWORD + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrAdminPass(authentication, #requestedId)")
        .antMatchers(
            HttpMethod.GET,
            CONTACT + "/{requestedId}",
            EDUCATION + "/{requestedId}",
            EMPLOYEE + "/{requestedId}",
            EXPERIENCE + "/{requestedId}",
            LANGUAGE_KNOWLEDGE + "/{requestedId}",
            PERSON + "/{requestedId}",
            SKILL_LEVEL + "/{requestedId}",
            TERMINATED_EMPLOYEE + "/{requestedId}",
            WORKING_EMPLOYEE + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRGet(authentication, #requestedId, request)")
        .antMatchers(CONTACT + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRContact(authentication, #requestedId)")
        .antMatchers(EDUCATION + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHREducation(authentication, #requestedId)")
        .antMatchers(EXPERIENCE + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRExperience(authentication, #requestedId)")
        .antMatchers(LANGUAGE_KNOWLEDGE + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRLanguage(authentication, #requestedId)")
        .antMatchers(PERSON + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRPerson(authentication, #requestedId)")
        .antMatchers(SKILL_LEVEL + "/{requestedId}")
        .access("@userSecurity.hasUserIdOrHRSkill(authentication, #requestedId)")
        .antMatchers(
            HR_WORKER + "/**",
            EMPLOYEE + "/**",
            TERMINATED_EMPLOYEE + "/**",
            WORKING_EMPLOYEE + "/**")
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(HttpMethod.POST)
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(HttpMethod.PUT)
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(HttpMethod.GET)
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(HttpMethod.DELETE)
        .hasAnyRole(ROLE_ADMIN, ROLE_HR)
        .antMatchers(HttpMethod.GET, "/all")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/hr")
        .hasRole(ROLE_HR)
        .antMatchers(HttpMethod.GET, "/emp/")
        .hasRole(ROLE_EMPLOYEE)
        .antMatchers(HttpMethod.GET, "/adm")
        .hasRole(ROLE_ADMIN)
        .anyRequest()
        .hasAnyRole(ROLE_HR, ROLE_ADMIN)
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
    corsConfiguration.setExposedHeaders(
        Arrays.asList(
            HEADER_STRING_AUTH,
            HEADER_STRING_ID,
            HEADER_STRING_REFRESH,
            HEADER_STRING_TYPE,
            HEADER_STRING_PERSON));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }

  @Bean
  public RequestContextListener requestContextListener() {
    return new RequestContextListener();
  }
}
