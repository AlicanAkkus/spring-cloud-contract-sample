package com.caysever.producer;

import com.caysever.producer.domain.AccountEntity;
import com.caysever.producer.domain.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProducerBaseTest {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private AccountRepository accountRepository;

    @LocalServerPort
    private Integer port;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(context);
        RestAssuredMockMvc.standaloneSetup(defaultMockMvcBuilder);

        AccountEntity accountEntity = createAccountEntity();
        when(accountRepository.retrieveById(1L)).thenReturn(Optional.of(accountEntity));
    }

    private AccountEntity createAccountEntity() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCreatedDate(LocalDateTime.of(2018, 1, 1, 23, 59, 59));
        accountEntity.setUpdatedDate(LocalDateTime.of(2018, 1, 1, 23, 59, 59));
        accountEntity.setName("Name");
        accountEntity.setSurname("Surname");
        accountEntity.setGender("Gender");
        accountEntity.setGsmNumber("GsmNumber");
        accountEntity.setIdentifier("Identifier");
        return accountEntity;
    }
}