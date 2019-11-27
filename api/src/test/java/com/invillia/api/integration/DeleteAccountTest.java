package com.invillia.api.integration;

import com.invillia.api.Response;
import com.invillia.api.factory.AccountFactory;
import com.invillia.api.repository.AccountRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeleteAccountTest {

    private final AccountFactory accountFactory;
    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccountTest(AccountFactory accountFactory, AccountRepository accountRepository) {
        this.accountFactory = accountFactory;
        this.accountRepository = accountRepository;
    }

    @Test
    void deleteWithSuccessTest(){
        accountFactory.create();

        RestAssured
                .given()
                    .log().all()
                .when()
                    .delete("/accounts/1")
                .then()
                    .log().all()
                    .statusCode(204);

        Assertions.assertEquals(0, accountRepository.count());
    }

    @Test
    void deleteByIdNotFoundTest(){

        RestAssured
                .given()
                    .log().all()
                .when()
                    .delete("/accounts/1")
                .then()
                    .log().all()
                    .specification(Response.notFound());
    }
}
