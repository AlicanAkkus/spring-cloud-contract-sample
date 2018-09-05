package com.caysever.producer.infra;

import com.caysever.producer.domain.AccountFacade;
import com.caysever.producer.domain.AccountRepository;
import com.caysever.producer.domain.RetrieveAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFacadeConfig {

    @Bean
    public AccountFacade accountFacade(AccountRepository accountRepository) {
        return new AccountFacade(new RetrieveAccountService(accountRepository));
    }
}