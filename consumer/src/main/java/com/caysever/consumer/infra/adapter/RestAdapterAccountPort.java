package com.caysever.consumer.infra.adapter;

import com.caysever.consumer.domain.Account;
import com.caysever.consumer.domain.AccountPort;
import org.springframework.web.client.RestTemplate;

public class RestAdapterAccountPort implements AccountPort {

    private final RestTemplate restTemplate;

    public RestAdapterAccountPort(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Account retrieve(Long accountId) {
        return restTemplate.getForEntity("http://localhost:8080/api/v1/accounts?accountId={accountId}", Account.class, accountId).getBody();
    }
}
