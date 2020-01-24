package com.invillia.api.integration.accountIntegration;

import com.invillia.api.domain.Account;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.factory.account.AccountFactory;
import com.invillia.api.factory.account.AccountRequestFactory;
import com.invillia.api.repository.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateAccountTest {

    private final AccountFactory accountFactory;

    private final AccountRequestFactory accountRequestFactory;

    private final AccountRepository accountRepository;

    @Autowired
    public UpdateAccountTest(AccountFactory accountFactory, AccountRequestFactory accountRequestFactory, AccountRepository accountRepository) {
        this.accountFactory = accountFactory;
        this.accountRequestFactory = accountRequestFactory;
        this.accountRepository = accountRepository;
    }

    @Test
    void updateWithSuccessTest(){
        accountFactory.create();
        final AccountRequest accountRequest = accountRequestFactory.build();

        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                .body(accountRequest)
                .when()
                    .put("/accounts/1")
                .then()
                    .log().all()
                    .statusCode(204);

        final Account account = accountRepository.findById(1L)
                .orElseThrow(ResourceNotFoundException::new);

        Assertions.assertAll("Account assert",
                () -> Assertions.assertEquals(accountRequest.getBalance(), account.getBalance()),
                () -> Assertions.assertEquals(accountRequest.getAccountLimit(), account.getAccountLimit()),
                () -> Assertions.assertEquals(accountRequest.getMaxLimit(), account.getMaxLimit()));
    }
}
