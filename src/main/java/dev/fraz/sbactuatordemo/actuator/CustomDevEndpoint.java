package dev.fraz.sbactuatordemo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "customDevEndpoint")
public class CustomDevEndpoint {

  @ReadOperation
  public List<String> customDevEndpoint() {
    List<String> devs = new ArrayList<>();
    devs.add("McGee");
    devs.add("Zonkey rocks");
    return devs;
  }
}
