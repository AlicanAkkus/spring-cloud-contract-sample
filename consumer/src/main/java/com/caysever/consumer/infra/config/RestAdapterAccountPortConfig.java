package com.caysever.consumer.infra.config;

import com.caysever.consumer.infra.adapter.RestAdapterAccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestAdapterAccountPortConfig {

    @Bean
    public RestAdapterAccountPort restAdapterAccountPort(RestTemplate restTemplate) {
        return new RestAdapterAccountPort(restTemplate);
    }
}