package com.caysever.consumer.domain;

public class AccountSettingsFacade {

    private final RetrieveAccountSettingsService retrieveAccountSettingsService;

    public AccountSettingsFacade(RetrieveAccountSettingsService retrieveAccountSettingsService) {
        this.retrieveAccountSettingsService = retrieveAccountSettingsService;
    }

    public AccountSettings retrieveAccountById(Long accountId) {
        return retrieveAccountSettingsService.retrieveAccountSettings(accountId);
    }
}