package com.caysever.producer;

import com.caysever.producer.domain.AccountEntity;
import com.caysever.producer.infra.adapter.JpaAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(JpaAccountRepository jpaAccountRepository) {
        return args -> {
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setCreatedDate(LocalDateTime.now());
            accountEntity.setUpdatedDate(LocalDateTime.now());
            accountEntity.setName("Name");
            accountEntity.setSurname("Surname");
            accountEntity.setGender("Gender");
            accountEntity.setGsmNumber("GsmNumber");
            accountEntity.setIdentifier(UUID.randomUUID().toString());

            jpaAccountRepository.save(accountEntity);
            log.info("Saved -> " + accountEntity);
        };
    }
}
