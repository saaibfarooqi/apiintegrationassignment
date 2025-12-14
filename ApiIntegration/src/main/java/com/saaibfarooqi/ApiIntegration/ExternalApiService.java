package com.saaibfarooqi.ApiIntegration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ExternalApiService {

    private final ExternalApiConfigRepository configRepository;
    private final List<String> tempResponses = new CopyOnWriteArrayList<>();

    @Value("${calendly.api.token}")
    private String calendlyToken;

    public ExternalApiService(ExternalApiConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    // ✅ Fully reactive method
    public WebClient createWebClient(String token) {
        return WebClient.builder().defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
    }

    public Mono<String> fetchFromExternalSystem(String systemName) {
        ExternalApiConfig config = configRepository.findBySystemName(systemName);
        if (config == null) {
            return Mono.error(new RuntimeException("No config found for " + systemName));
        }
        System.out.println();
        return createWebClient(calendlyToken).get().uri(config.getApiUrl()).retrieve().bodyToMono(String.class).doOnNext(tempResponses::add);


    }

    public List<String> getTempResponses() {
        return tempResponses;
    }
    public Map parseJsonString(String json) {
        try {
            return new ObjectMapper().readValue(json, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }
}



