package com.caysever.producer.infra.controller;

import com.caysever.producer.domain.Account;
import com.caysever.producer.domain.AccountFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/accounts")
public class RestAccountController {

    private final AccountFacade accountFacade;

    public RestAccountController(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @GetMapping
    public Mono<Account> retrieve(@RequestParam Long id) {
        return Mono.justOrEmpty(accountFacade.retrieveAccountById(id));
    }
}