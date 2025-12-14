package com.saaibfarooqi.ApiIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;


    @GetMapping("/fetch/{systemName}")
    public Mono<Map<String, Object>> fetchFromExternalSystem(@PathVariable String systemName) {
        return externalApiService.fetchFromExternalSystem(systemName)
        .map(jsonString -> externalApiService.parseJsonString(jsonString));

    }


    @GetMapping("/temp")
    public List<String> getTempResponses() {
        return externalApiService.getTempResponses();
    }
}
