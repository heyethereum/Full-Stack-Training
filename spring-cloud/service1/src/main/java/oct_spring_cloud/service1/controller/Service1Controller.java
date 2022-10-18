package oct_spring_cloud.service1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {
  @GetMapping("/test")
  public ResponseEntity<String> testService2() {
    return new ResponseEntity<>("code 200: whatever object here", HttpStatus.OK);
  }
}
