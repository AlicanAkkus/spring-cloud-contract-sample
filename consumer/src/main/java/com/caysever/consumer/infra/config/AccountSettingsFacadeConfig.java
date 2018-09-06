package com.caysever.consumer.infra.config;

import com.caysever.consumer.domain.AccountSettingsFacade;
import com.caysever.consumer.domain.AccountSettingsRepository;
import com.caysever.consumer.domain.RetrieveAccountSettingsService;
import com.caysever.consumer.infra.adapter.RestAdapterAccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AccountSettingsFacadeConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AccountSettingsFacade accountSettingsFacade(AccountSettingsRepository accountSettingsRepository, RestTemplate restTemplate) {
        return new AccountSettingsFacade(new RetrieveAccountSettingsService(accountSettingsRepository, new RestAdapterAccountPort(restTemplate)));
    }
}