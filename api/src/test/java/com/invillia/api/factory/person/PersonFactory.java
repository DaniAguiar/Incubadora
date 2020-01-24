package com.invillia.api.factory.person;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.api.domain.Person;
import com.invillia.api.repository.PersonRepository;

public class PersonFactory extends JBacon<Person> {

    private final PersonRepository personRepository;
    private final Faker faker;

    public PersonFactory(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }

    @Override
    protected Person getDefault(){
        final Person person = new Person();

        person.setName(faker.name().fullName());

        return person;
    }

    @Override
    protected Person getEmpty(){
        return new Person();
    }

    @Override
    protected void persist(final Person person){
        personRepository.save(person);
    }
}
