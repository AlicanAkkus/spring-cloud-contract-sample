package com.caysever.consumer.infra.adapter;

import com.caysever.consumer.domain.AccountSettings;
import com.caysever.consumer.domain.AccountSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountSettingsRepository extends JpaRepository<AccountSettingsEntity, Long> {

    Optional<AccountSettingsEntity> findById(Long id);

    Optional<AccountSettingsEntity> findByAccountId(Long accountId);
}
