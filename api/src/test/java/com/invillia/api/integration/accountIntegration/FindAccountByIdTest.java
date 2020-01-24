package com.invillia.api.integration.accountIntegration;

import com.invillia.api.Response;
import com.invillia.api.domain.Account;
import com.invillia.api.factory.account.AccountFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAccountByIdTest {

    private static  final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private final AccountFactory accountFactory;

    @Autowired
    public FindAccountByIdTest(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    @Test
    void findByIdWithSuccess(){
        final Account account = accountFactory.create();

        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/accounts/1")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", Matchers.is(1))
                    .body("balance", Matchers.is(account.getBalance().floatValue()))
                    .body("accountLimit", Matchers.is(account.getAccountLimit().floatValue()))
                    .body("maxLimit", Matchers.is(account.getMaxLimit().floatValue()))
                    .body("createdAt", Matchers.is(account.getCreatedAt().format(FORMATTER)))
                    .body("updatedAt", Matchers.is(account.getUpdatedAt().format(FORMATTER)))
                    .body("person", Matchers.is(account.getPerson()));
    }

    @Test
    void findByIdWithoutSuccess(){

        RestAssured
                .given()
                    .log().all()
                .when()
                    .get("/accounts/1")
                .then()
                    .log().all()
                    .specification(Response.notFound("Not Found!"));
    }
}
