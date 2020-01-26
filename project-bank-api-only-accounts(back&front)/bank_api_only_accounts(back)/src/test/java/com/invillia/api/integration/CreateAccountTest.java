package com.invillia.api.integration;

import com.invillia.api.domain.Account;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.factory.AccountRequestFactory;
import com.invillia.api.repository.AccountRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateAccountTest {

    private final AccountRepository accountRepository;
    private final AccountRequestFactory accountRequestFactory;

    @Autowired
    public CreateAccountTest(AccountRepository accountRepository, AccountRequestFactory accountRequestFactory) {
        this.accountRepository = accountRepository;
        this.accountRequestFactory = accountRequestFactory;
    }

    @Test
    void createWithSuccessTest(){

        final AccountRequest accountRequest = accountRequestFactory.build();

        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(accountRequest)
                .when()
                    .post("/accounts")
                .then()
                    .log().all()
                    .statusCode(201)
                    .header("Location", Matchers.endsWith("/accounts/1"));

        Assertions.assertEquals(1, accountRepository.count());

        final Account account = accountRepository.findById(1L)
                .orElseThrow(ResourceNotFoundException::new);

        Assertions.assertAll("Account Assert",
                () -> Assertions.assertEquals(accountRequest.getBalance(), account.getBalance()),
                () -> Assertions.assertEquals(accountRequest.getAccountLimit(), account.getAccountLimit()),
                () -> Assertions.assertEquals(accountRequest.getMaxLimit(), account.getMaxLimit()));
    }

    @Test
    void createWithoutSuccessTest(){
        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(new AccountRequest())
                .when()
                    .post("/accounts")
                .then()
                    .log().all()
                    .statusCode(400)
                    .body("balance", Matchers.isEmptyOrNullString())
                    .body("accountLimit", Matchers.isEmptyOrNullString())
                    .body("maxLimit", Matchers.isEmptyOrNullString());
    }
}
