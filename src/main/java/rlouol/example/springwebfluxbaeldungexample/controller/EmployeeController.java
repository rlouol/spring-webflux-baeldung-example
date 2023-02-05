package rlouol.example.springwebfluxbaeldungexample.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rlouol.example.springwebfluxbaeldungexample.client.EmployeeWebClient;
import rlouol.example.springwebfluxbaeldungexample.model.Employee;
import rlouol.example.springwebfluxbaeldungexample.repository.EmployeeRepository;

/**
 *  Employee 자원의 반응형 스트림을 publish하는 어노테이션이 달린 컨트롤러를 만들 수 있다.
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

  // EmployeeRepository는 논블로킹 리액티브 스트림을 지원하는 아무 data repository로 가능
  private final EmployeeRepository employeeRepository;
  private final EmployeeWebClient client;


  public EmployeeController(EmployeeRepository employeeRepository, EmployeeWebClient client) {
    this.employeeRepository = employeeRepository;
    this.client = client;
  }

  // 최대 한 명의 Employee를 반환하기 때문에 단일 Employee 자원을 Mono 타입으로 wrap한다.
  @GetMapping("/{id}")
  private Mono<Employee> getEmployeeById(@PathVariable String id) {
    return employeeRepository.findEmployeeById(id);
  }

  // 컬렉션 자원은 0~n개의 자원을 publish 해야 하기 때문에 Flux<Employee> 타입을 쓴다.
  @GetMapping
  private Flux<Employee> getAllEmployees() {
    return employeeRepository.findAllEmployees();
  }

  @PostMapping("/update")
  private Mono<Employee> updateEmployee(@RequestBody Employee employee) {
    return employeeRepository.updateEmployee(employee);
  }

  @GetMapping("/mono")
  private void checkSingleResource() {
    client.retrieveSingleEmployee();
  }

  @GetMapping("/flux")
  private void checkCollectionResource() {
    client.retrieveCollectionEmployee();
  }

}
