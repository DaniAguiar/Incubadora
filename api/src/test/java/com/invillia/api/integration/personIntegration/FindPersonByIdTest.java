package com.invillia.api.integration.personIntegration;

import com.invillia.api.Response;
import com.invillia.api.domain.Account;
import com.invillia.api.domain.Person;
import com.invillia.api.factory.account.AccountFactory;
import com.invillia.api.factory.person.PersonFactory;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindPersonByIdTest {
    private static  final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private final PersonFactory personFactory;

    @Autowired
    public FindPersonByIdTest(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    @Test
    void findByIdWithSuccess(){
        final Person person = personFactory.create();

        RestAssured
                .given()
                .log().all()
                .when()
                .get("/people/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", Matchers.is(1))
                .body("name", Matchers.is(person.getName()))
                .body("createdAt", Matchers.is(person.getCreatedAt().format(FORMATTER)))
                .body("updatedAt", Matchers.is(person.getUpdatedAt().format(FORMATTER)));
    }

    @Test
    void findByIdWithoutSuccess(){

        RestAssured
                .given()
                .log().all()
                .when()
                .get("/people/1")
                .then()
                .log().all()
                .specification(Response.notFound("Not Found!"));
    }
}
