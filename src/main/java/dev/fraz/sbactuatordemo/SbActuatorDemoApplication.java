package dev.fraz.sbactuatordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbActuatorDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbActuatorDemoApplication.class, args);
  }

  // To enable tracing we need to add this bean, it can be customized
  @Bean
  public HttpTraceRepository httpTraceRepository() {
    return new InMemoryHttpTraceRepository();
  }
}
