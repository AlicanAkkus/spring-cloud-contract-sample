package com.caysever.consumer.domain;

import java.time.ZoneOffset;
import java.util.function.Function;

public class RetrieveAccountSettingsService {

    private final AccountSettingsRepository accountSettingsRepository;
    private final AccountPort accountPort;

    public RetrieveAccountSettingsService(AccountSettingsRepository accountSettingsRepository, AccountPort accountPort) {
        this.accountSettingsRepository = accountSettingsRepository;
        this.accountPort = accountPort;
    }

    AccountSettings retrieveAccountSettings(Long accountId) {
        return accountSettingsRepository.retrieveByAccountId(accountId)
                .map(convert())
                .map(addAccountInfo())
                .orElseThrow(RuntimeException::new);
    }

    private Function<AccountSettings, AccountSettings> addAccountInfo() {
        return accountSettings -> {
            Account account = accountPort.retrieve(accountSettings.getAccountId());
            accountSettings.setName(account.getName());
            accountSettings.setSurname(account.getSurname());

            return accountSettings;
        };
    }

    private Function<AccountSettingsEntity, AccountSettings> convert() {
        return accountSettingsEntity -> AccountSettings.builder()
                .accountId(accountSettingsEntity.getAccountId())
                .createdDate(accountSettingsEntity.getCreatedDate().toEpochSecond(ZoneOffset.UTC))
                .updatedDate(accountSettingsEntity.getUpdatedDate().toEpochSecond(ZoneOffset.UTC))
                .build();
    }
}