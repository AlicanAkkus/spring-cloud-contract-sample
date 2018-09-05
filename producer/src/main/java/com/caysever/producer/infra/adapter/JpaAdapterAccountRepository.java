package com.caysever.producer.infra.adapter;

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

    private final JpaAccountRepository jpaAccountRepository;

    public JpaAdapterAccountRepository(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public Optional<AccountEntity> retrieveById(Long id) {
        return jpaAccountRepository.findById(id);
    }

    @Override
    public Optional<AccountEntity> retrieveByIdentifier(String identifier) {
        return jpaAccountRepository.findByIdentifier(identifier);
    }

    @Override
    public List<AccountEntity> retrieveAll() {
        return jpaAccountRepository.findAll();
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

        jpaAccountRepository.save(accountEntity);
    }
}
