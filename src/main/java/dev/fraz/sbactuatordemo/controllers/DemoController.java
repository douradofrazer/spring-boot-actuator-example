package dev.fraz.sbactuatordemo.controllers;

import dev.fraz.sbactuatordemo.services.DemoService;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed
public class DemoController {

  private final DemoService demoService;

  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  @GetMapping("/demo")
  public ResponseEntity<String> demo() {
    return new ResponseEntity<>(demoService.gettext(), HttpStatus.OK);
  }
}
