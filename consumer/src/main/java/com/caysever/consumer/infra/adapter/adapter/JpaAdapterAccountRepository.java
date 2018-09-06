package com.caysever.consumer.infra.adapter.adapter;

import com.caysever.producer.domain.Account;
import com.caysever.producer.domain.AccountEntity;
import com.caysever.producer.domain.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JpaAdapterAccountRepository implements AccountRepository {

    private final JpaAccountSettingsRepository jpaAccountSettingsRepository;

    public JpaAdapterAccountRepository(JpaAccountSettingsRepository jpaAccountSettingsRepository) {
        this.jpaAccountSettingsRepository = jpaAccountSettingsRepository;
    }

    @Override
    public Optional<AccountEntity> retrieveById(Long id) {
        return jpaAccountSettingsRepository.findById(id);
    }

    @Override
    public Optional<AccountEntity> retrieveByIdentifier(String identifier) {
        return jpaAccountSettingsRepository.findByIdentifier(identifier);
    }

    @Override
    public List<AccountEntity> retrieveAll() {
        return jpaAccountSettingsRepository.findAll();
    }

    @Override
    public void create(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCreatedDate(LocalDateTime.now());
        accountEntity.setName(account.getName());
        accountEntity.setSurname(account.getSurname());
        accountEntity.setGender(account.getGender());
        accountEntity.setGsmNumber(account.getGsmNumber());
        accountEntity.setIdentifier(UUID.randomUUID().toString());

        jpaAccountSettingsRepository.save(accountEntity);
    }
}
