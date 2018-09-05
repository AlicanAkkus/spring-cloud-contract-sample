package com.caysever.producer.domain;

import java.time.ZoneOffset;
import java.util.function.Function;

public class RetrieveAccountService {

    private final AccountRepository accountRepository;

    public RetrieveAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    Account retrieveAccount(Long accountId) {
        return accountRepository.retrieveById(accountId)
                .map(convert())
                .orElseThrow(RuntimeException::new);
    }

    Account retrieveAccount(String accountIdentifier) {
        return accountRepository.retrieveByIdentifier(accountIdentifier)
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