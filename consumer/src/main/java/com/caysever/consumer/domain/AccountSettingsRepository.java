package com.caysever.consumer.domain;

import java.util.List;
import java.util.Optional;

public interface AccountSettingsRepository {

    Optional<AccountSettingsEntity> retrieveById(Long id);

    Optional<AccountSettingsEntity> retrieveByAccountId(Long accountId);

    List<AccountSettingsEntity> retrieveAll();

    void create(AccountSettings accountSettings);
}