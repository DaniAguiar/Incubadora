package com.invillia.api.integration.personIntegration;

import com.invillia.api.Response;
import com.invillia.api.factory.person.PersonFactory;
import com.invillia.api.repository.PersonRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeletePersonTest {
    private final PersonRepository personRepository;
    private final PersonFactory personFactory;

    @Autowired
    public DeletePersonTest(PersonRepository personRepository, PersonFactory personFactory) {
        this.personRepository = personRepository;
        this.personFactory = personFactory;
    }

    @Test
    void deleteWithSucessTest(){
        personFactory.create();

        RestAssured
                .given()
                .log().all()
                .when()
                .delete("/people/1")
                .then()
                .log().all()
                .statusCode(204);

        Assertions.assertEquals(0, personRepository.count());
    }

    @Test
    void deleteWithoutSucessTest(){
        RestAssured
                .given()
                .log().all()
                .when()
                .delete("/people/1")
                .then()
                .log().all()
                .specification(Response.notFound(" Person not found"));
    }
}
