package rlouol.example.springwebfluxbaeldungexample.config;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 응답이 올 때마다 특정 헤더값을 추가
 */
@Component
public class ExampleWebFilter implements WebFilter {

  // HTTP header 표준에서 한글은 미포함 https://www.rfc-editor.org/rfc/rfc5987
  @Override
  public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
    final var headers = serverWebExchange.getResponse().getHeaders();

    headers.setContentType(MediaType.TEXT_PLAIN);
    headers.add("web-filter", "meowwww");
    return webFilterChain.filter(serverWebExchange);
  }
}
