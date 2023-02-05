package rlouol.example.springwebfluxbaeldungexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

  // ADMIN ROLE이 있는 사용자만 /emp/update POST 엔드포인트에 액세스 설정
  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(
      ServerHttpSecurity http) {
    http.csrf().disable()
        .authorizeExchange()
        .pathMatchers(HttpMethod.POST, "/emp/update").hasRole("ADMIN")
        .pathMatchers("/**").permitAll()
        .and()
        .httpBasic();
    return http.build();
  }

}
