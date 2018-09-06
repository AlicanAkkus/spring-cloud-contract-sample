package com.caysever.consumer.infra.adapter;

import com.caysever.consumer.domain.AccountSettings;
import com.caysever.consumer.domain.AccountSettingsEntity;
import com.caysever.consumer.domain.AccountSettingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdapterAccountSettingsRepository implements AccountSettingsRepository {

    private final JpaAccountSettingsRepository jpaAccountSettingsRepository;

    public JpaAdapterAccountSettingsRepository(JpaAccountSettingsRepository jpaAccountSettingsRepository) {
        this.jpaAccountSettingsRepository = jpaAccountSettingsRepository;
    }

    @Override
    public Optional<AccountSettingsEntity> retrieveById(Long id) {
        return jpaAccountSettingsRepository.findById(id);
    }

    @Override
    public Optional<AccountSettingsEntity> retrieveByAccountId(Long accountId) {
        return jpaAccountSettingsRepository.findByAccountId(accountId);
    }

    @Override
    public List<AccountSettingsEntity> retrieveAll() {
        return jpaAccountSettingsRepository.findAll();
    }

    @Override
    public void create(AccountSettings accountSettings) {

    }
}
