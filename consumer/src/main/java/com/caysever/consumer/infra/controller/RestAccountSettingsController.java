package com.caysever.consumer.infra.controller;

import com.caysever.consumer.domain.AccountSettings;
import com.caysever.consumer.domain.AccountSettingsFacade;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/accounts")
public class RestAccountSettingsController {

    private final AccountSettingsFacade accountSettingsFacade;

    public RestAccountSettingsController(AccountSettingsFacade accountSettingsFacade) {
        this.accountSettingsFacade = accountSettingsFacade;
    }

    @GetMapping("{accountId}/settings")
    public Mono<AccountSettings> retrieveSettings(@PathVariable Long accountId){
        return Mono.just(accountSettingsFacade.retrieveAccountById(accountId));
    }
}