package rlouol.example.springwebfluxbaeldungexample.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import rlouol.example.springwebfluxbaeldungexample.model.Employee;

@Component
public class EmployeeWebClient {


  WebClient client = WebClient.create("http://localhost:8080");


  public void retrieveSingleEmployee() {
    final var result = client.get()
        .uri("/emp/{id}", 1)
        .retrieve()
        .bodyToMono(Employee.class);

    result.subscribe(System.out::println);
  }

  public void retrieveCollectionEmployee() {
    final var result = client.get()
        .uri("/emp")
        .retrieve()
        .bodyToFlux(Employee.class);

    result.subscribe(System.out::println);
  }
}
