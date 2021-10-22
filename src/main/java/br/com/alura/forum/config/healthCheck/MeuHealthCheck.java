package br.com.alura.forum.config.healthCheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MeuHealthCheck implements HealthIndicator {
    private final ApplicationAvailability availability;

    public MeuHealthCheck(ApplicationAvailability availability) {
        this.availability = availability;
    }


    @Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();
        details.put("versão", "1.2.3");
        details.put("descrição", "Meu primeiro Health Check customizado!");
        details.put("endereço", "127.0.0.1");
        details.put("livenessState",availability.getLivenessState());
        details.put("readinessState",availability.getReadinessState());

        return Health.status(Status.UP).withDetails(details).build();

    }
}
