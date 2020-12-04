package dev.fraz.sbactuatordemo.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

  private final Counter textCounter;
  private Gauge textGauge;
  private int viewCount = 0;

  public DemoServiceImpl(MeterRegistry registry) {
    this.textCounter =
        Counter.builder("dev.fraz.sbactuatordemo.services.DemoServiceImpl.getText")
            .tags("id", "server_requests")
            .description("This counts the number of times demo endpoint is request!")
            .register(registry);
  }

  @Override
  public String gettext() {
    textCounter.increment();
    viewCount++;
    this.textGauge =
        Gauge.builder("dev.fraz.sbactuatordemo.services.DemoServiceImpl.gettext.apageViews", () -> viewCount)
            .register(Metrics.globalRegistry);
    return "Hello World!";
  }
}
