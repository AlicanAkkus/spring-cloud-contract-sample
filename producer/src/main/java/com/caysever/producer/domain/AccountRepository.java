package com.caysever.producer.domain;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<AccountEntity> retrieveById(Long id);

    Optional<AccountEntity> retrieveByIdentifier(String identifier);

    List<AccountEntity> retrieveAll();

    void create(Account account);
}