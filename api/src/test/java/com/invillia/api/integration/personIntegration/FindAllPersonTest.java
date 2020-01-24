package com.invillia.api.integration.personIntegration;

import com.invillia.api.factory.account.AccountFactory;
import com.invillia.api.factory.person.PersonFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAllPersonTest {
    private final PersonFactory personFactory;

    @Autowired
    public FindAllPersonTest(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    @Test
    void findAllWithSuccessTest(){

        personFactory.create(5);

        RestAssured
                .given()
                .log().all()
                .when()
                .get("/people")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", Matchers.hasSize(5));
    }
}
