package com.caysever.consumer;

import com.caysever.consumer.domain.AccountSettingsEntity;
import com.caysever.consumer.infra.adapter.JpaAccountSettingsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(JpaAccountSettingsRepository jpaAccountSettingsRepository) {
        return args -> {
            AccountSettingsEntity accountSettingsEntity = new AccountSettingsEntity();
            accountSettingsEntity.setAccountId(1L);
            accountSettingsEntity.setPushNotificationEnabled(true);
            accountSettingsEntity.setVerified(true);

            jpaAccountSettingsRepository.save(accountSettingsEntity);
            log.info("Saved -> " + accountSettingsEntity);
        };
    }
}
