package com.caysever.producer.domain;

public class AccountFacade {

    private final RetrieveAccountService retrieveAccountService;

    public AccountFacade(RetrieveAccountService retrieveAccountService) {
        this.retrieveAccountService = retrieveAccountService;
    }

    public Account retrieveAccountById(Long accountId) {
        return retrieveAccountService.retrieveAccount(accountId);
    }

    public Account retrieveAccountByIdentifier(String accountIdentifier) {
        return retrieveAccountService.retrieveAccount(accountIdentifier);
    }
}