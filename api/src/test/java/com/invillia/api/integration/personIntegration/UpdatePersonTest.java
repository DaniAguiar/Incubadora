package com.invillia.api.integration.personIntegration;

import com.invillia.api.domain.Account;
import com.invillia.api.domain.Person;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.domain.request.PersonRequest;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.factory.person.PersonFactory;
import com.invillia.api.factory.person.PersonRequestFactory;
import com.invillia.api.repository.PersonRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdatePersonTest {
    private final PersonFactory personFactory;

    private final PersonRequestFactory personRequestFactory;

    private final PersonRepository personRepository;

    @Autowired
    public UpdatePersonTest(PersonFactory personFactory, PersonRequestFactory personRequestFactory, PersonRepository personRepository) {
        this.personFactory = personFactory;
        this.personRequestFactory = personRequestFactory;
        this.personRepository = personRepository;
    }

    @Test
    void updateWithSuccessTest(){
        personFactory.create();
        final PersonRequest personRequest = personRequestFactory.build();

        RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(personRequest)
                .when()
                .put("/people/1")
                .then()
                .log().all()
                .statusCode(204);

        final Person person = personRepository.findById(1L)
                .orElseThrow(ResourceNotFoundException::new);

        Assertions.assertAll("Person assert",
                () -> Assertions.assertEquals(personRequest.getName(), person.getName()));
    }
}
