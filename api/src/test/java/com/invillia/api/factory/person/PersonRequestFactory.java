package com.invillia.api.factory.person;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.api.domain.request.PersonRequest;
import org.springframework.stereotype.Component;

@Component
public class PersonRequestFactory extends JBacon<PersonRequest> {

    private final Faker faker;

    public PersonRequestFactory(Faker faker) {
        this.faker = faker;
    }

    @Override
    protected PersonRequest getDefault() {
        final PersonRequest personRequest = new PersonRequest();

        personRequest.setName(faker.name().fullName());

        return personRequest;
    }

    @Override
    protected PersonRequest getEmpty() {
        return new PersonRequest();
    }

    @Override
    protected void persist(PersonRequest personRequest) {
        throw new UnsupportedOperationException();
    }
}
