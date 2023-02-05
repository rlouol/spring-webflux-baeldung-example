## 개요

Spring 5에는 웹 애플리케이션에 대한 리액티브 프로그래밍 지원을 제공하는 Spring WebFlux가 포함되어 있다.

이 튜토리얼에서, 리액티브 웹 구성 요소 RestController와 WebClient를 사용하여 조그만한 리액티브 REST 애플리케이션을 만들어본다.

또한 Spring Security를 사용하여 반응성 엔드포인트를 보호하는 방법을 알아본다.

<br>

## Spring WebFlux Framework

Spring Webflux는 내부적으로 Project Reactor와 Reactor의 pulisher 구현인 Flux 및 Mono를 사용한다.

Webflux 프레임워크는 두 가지 프로그래밍 모델을 지원한다.

- 어노테이션 기반 reactive-components

- 함수형 라우팅 및 핸들링

<br>

## Dependencies

- spring-boot and spring-boot-starter (기본적인 Spring Boot Application 셋팅)

- spring-webflux framework

- reactor-core (reactive streams과 reactor-netty 필요)

<br>

## Reactive REST Application

Spring Webflux를 사용하여 매우 간단한 반응형 REST EmployeeManagement 애플리케이션을 구축해본다.

- 간단한 도메인 모델 사용 - id와 name 필드가 있는 Employee

- RestController로 REST API를 구축하여 Employee 리소스를 단일 리소스와 컬렉션으로 publish

- 동일한 리소스를 검색하기 위해 WebClient로 클라이언트를 구축

- Webflux와 Spring Security를 사용하여 안전한 반응형 엔드포인트를 만들기

<br>

## Reference

Link : https://www.baeldung.com/spring-webflux