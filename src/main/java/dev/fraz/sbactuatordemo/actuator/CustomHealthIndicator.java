package dev.fraz.sbactuatordemo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.util.Random;

//@Component // commented out to prevent it from being used
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        Random random = new Random();

        if(random.nextBoolean()){
            return Health.down().withDetail("ERR-001", "Random failure").build();
        }

        return Health.up().build();
    }
}
