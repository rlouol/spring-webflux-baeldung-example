package rlouol.example.springwebfluxbaeldungexample.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * name pathVariable이 test와 똑같으면 403 Forbidden 응답
 */
public class ExampleHandlerFilterFunction implements HandlerFilterFunction<ServerResponse, ServerResponse> {

  @Override
  public Mono<ServerResponse> filter(ServerRequest serverRequest, HandlerFunction<ServerResponse> handlerFunction) {
    if(serverRequest.pathVariable("name").equalsIgnoreCase("test")) {
      return ServerResponse.status(HttpStatus.FORBIDDEN).build();
    }
    return handlerFunction.handle(serverRequest);
  }
}
