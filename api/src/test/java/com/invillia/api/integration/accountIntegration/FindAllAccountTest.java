package com.invillia.api.integration.accountIntegration;

import com.invillia.api.factory.account.AccountFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAllAccountTest {

    private final AccountFactory accountFactory;

    @Autowired
    public FindAllAccountTest(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    @Test
    void findAllWithSuccessTest(){

        accountFactory.create(5);

        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/accounts")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("$", Matchers.hasSize(5));
    }
}
