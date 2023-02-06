package rlouol.example.springwebfluxbaeldungexample.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import rlouol.example.springwebfluxbaeldungexample.config.ExampleHandlerFilterFunction;
import rlouol.example.springwebfluxbaeldungexample.handler.PlayerHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class PlayerRouter {

  // 함수형 엔드포인트
  @Bean
  public RouterFunction<ServerResponse> route(PlayerHandler playerHandler) {
    return RouterFunctions
        .route(GET("/players/{name}"), playerHandler::getName)
        .filter(new ExampleHandlerFilterFunction());
  }

}
