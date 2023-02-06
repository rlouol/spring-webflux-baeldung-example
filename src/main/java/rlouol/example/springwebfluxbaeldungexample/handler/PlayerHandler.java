package rlouol.example.springwebfluxbaeldungexample.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class PlayerHandler {

  public Mono<ServerResponse> getName(ServerRequest request) {
    return ok().body(
        Mono.just(request.pathVariable("name")),
        String.class
    );
  }
}
