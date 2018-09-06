package com.caysever.consumer.domain;

import java.time.ZoneOffset;
import java.util.function.Function;

public class RetrieveAccountSettingsService {

    private final AccountSettingsRepository accountSettingsRepository;

    public RetrieveAccountSettingsService(AccountSettingsRepository accountSettingsRepository) {
        this.accountSettingsRepository = accountSettingsRepository;
    }

    Account retrieveAccount(Long accountId) {
        return accountSettingsRepository.retrieveById(accountId)
                .map(convert())
                .orElseThrow(RuntimeException::new);
    }

    Account retrieveAccount(String accountIdentifier) {
        return accountSettingsRepository.retrieveByIdentifier(accountIdentifier)
                .map(convert())
                .orElseThrow(RuntimeException::new);
    }

    private Function<AccountEntity, Account> convert() {
        return accountEntity -> Account.builder()
                .name(accountEntity.getName())
                .surname(accountEntity.getSurname())
                .createdDate(accountEntity.getCreatedDate().toEpochSecond(ZoneOffset.UTC))
                .updatedDate(accountEntity.getUpdatedDate().toEpochSecond(ZoneOffset.UTC))
                .gender(accountEntity.getGender())
                .gsmNumber(accountEntity.getGsmNumber())
                .identifier(accountEntity.getIdentifier())
                .build();
    }
}