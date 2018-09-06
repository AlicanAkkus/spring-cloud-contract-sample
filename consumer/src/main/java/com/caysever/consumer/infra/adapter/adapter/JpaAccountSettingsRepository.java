package com.caysever.consumer.infra.adapter.adapter;

import com.caysever.consumer.domain.AccountSettings;
import com.caysever.producer.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountSettingsRepository extends JpaRepository<AccountSettings, Long> {

    Optional<AccountSettings> findByIdentifier(String identifier);
}
