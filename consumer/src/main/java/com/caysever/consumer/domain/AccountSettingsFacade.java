package com.caysever.consumer.domain;

public class AccountSettingsFacade {

    private final RetrieveAccountSettingsService retrieveAccountSettingsService;

    public AccountSettingsFacade(RetrieveAccountSettingsService retrieveAccountSettingsService) {
        this.retrieveAccountSettingsService = retrieveAccountSettingsService;
    }

    public Account retrieveAccountById(Long accountId) {
        return retrieveAccountSettingsService.retrieveAccount(accountId);
    }

    public Account retrieveAccountByIdentifier(String accountIdentifier) {
        return retrieveAccountSettingsService.retrieveAccount(accountIdentifier);
    }
}