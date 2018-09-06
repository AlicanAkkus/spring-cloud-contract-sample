package com.caysever.consumer;

import com.caysever.consumer.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(ids = "com.caysever:producer:+:8090", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ProducerVerifierTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void should_retrieveAccountById() {
        //given
        Long accountId = 1L;

        //when
        Account account = webTestClient.get()
                .uri("http://localhost:8090/api/v1/accounts?accountId={accountId}", accountId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Account.class)
                .returnResult()
                .getResponseBody();

        //then
        assertThat(account).isNotNull();
        assertThat(account.getName()).isEqualTo("Name");
        assertThat(account.getSurname()).isEqualTo("Surname");
        assertThat(account.getGender()).isEqualTo("Gender");
        assertThat(account.getGsmNumber()).isEqualTo("GsmNumber");
        assertThat(account.getIdentifier()).isEqualTo("Identifier");
        assertThat(account.getCreatedDate()).isEqualTo(1514851199);
        assertThat(account.getUpdatedDate()).isEqualTo(1514851199);
    }
}