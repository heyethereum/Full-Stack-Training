package oct_spring_cloud.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/service2")
public class Service2Controller {
  @Autowired
  RestTemplate restTemplate;

  @Autowired
  private CircuitBreakerFactory circuitBreakerFactory;

  @GetMapping("/test")
  public ResponseEntity<?> testService1() {
    // getForObject = GET method
    // postForObject = POST method
    String response = restTemplate.getForObject("http://localhost:8081/service1/test", String.class);

    System.out.println(response);

    return new ResponseEntity<>("Response from service 2 calling service 1 endpoint --->  " + response, HttpStatus.OK);
  }

  private String getDefaultFunction() {
    return "Error happened but success code sent :P";
  }

  @GetMapping("/circuitbreaker")
  public String circuitBreakerSample() {
    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitebreaker");
    // String url = "https://jsonplaceholder.typicode.com/albums";
    String url = "https://unreal.api.url";

    return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> getDefaultFunction());
  }
}
