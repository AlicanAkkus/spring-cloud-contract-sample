package com.caysever.producer.infra.adapter;

import com.caysever.producer.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByIdentifier(String identifier);
}
