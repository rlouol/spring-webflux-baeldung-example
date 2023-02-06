package rlouol.example.springwebfluxbaeldungexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithMockUser
public class AnnotationBaseEndpointTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void whenUserNameIsCat_thenWebFilterIsApplied() {
    EntityExchangeResult<String> result = webTestClient.get()
        .uri("/users/cat")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class)
        .returnResult();

    Assertions.assertEquals("cat", result.getResponseBody());
    Assertions.assertEquals("meowwww", result.getResponseHeaders().getFirst("web-filter"));
  }

  @Test
  public void whenUserNameIsTest_thenHandlerFilterFunctionIsNotApplied() {
    webTestClient.get()
        .uri("/users/test")
        .exchange()
        .expectStatus().isOk();
  }
}
