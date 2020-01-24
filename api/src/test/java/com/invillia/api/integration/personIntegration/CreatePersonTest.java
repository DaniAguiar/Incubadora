package com.invillia.api.integration.personIntegration;

import com.invillia.api.domain.Person;
import com.invillia.api.domain.request.PersonRequest;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.factory.person.PersonRequestFactory;
import com.invillia.api.repository.PersonRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreatePersonTest {
    private final PersonRepository personRepository;
    private final PersonRequestFactory personRequestFactory;

    @Autowired
    public CreatePersonTest(PersonRepository personRepository, PersonRequestFactory personRequestFactory) {
        this.personRepository = personRepository;
        this.personRequestFactory = personRequestFactory;
    }

    @Test
    void createWithSuccessTest(){

        final PersonRequest personRequest = personRequestFactory.build();

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(personRequest)
                .when()
                .post("/people")
                .then()
                .log().all()
                .statusCode(201)
                .header("Location", Matchers.endsWith("/people/1"));

        Assertions.assertEquals(1, personRepository.count());

        final Person person = personRepository.findById(1L)
                .orElseThrow(ResourceNotFoundException::new);

        Assertions.assertAll("Person Assert",
                () -> Assertions.assertEquals(personRequest.getName(), person.getName()));
    }

    @Test
    void createWithoutSuccessTest(){
        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(new PersonRequest())
                .when()
                .post("/people")
                .then()
                .log().all()
                .statusCode(400)
                .body("name", Matchers.isEmptyOrNullString());
    }
}
