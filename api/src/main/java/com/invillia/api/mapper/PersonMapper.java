package com.invillia.api.mapper;

import com.invillia.api.domain.Person;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.domain.request.PersonRequest;
import com.invillia.api.domain.response.PersonResponse;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public PersonResponse personToPersonResponse(final Person person){
        final PersonResponse personResponse = new PersonResponse();

        personResponse.setId(person.getId());
        personResponse.setName(person.getName());
        personResponse.setName(person.getName());

        return personResponse;
    }

    public List<PersonResponse> personToPersonResponse(final List<Person> people){
        return people.stream()
                .map(this::personToPersonResponse)
                .collect(Collectors.toList());
    }

    public Person personRequestToPerson(final PersonRequest personRequest){
        final Person person = new Person();

        person.setName(personRequest.getName());
        person.setCpf(personRequest.getCpf());

        return person;
    }

    public void updatePersonToPersonRequest(final Person person, final PersonRequest personRequest){
        person.setName(personRequest.getName());
        person.setCpf(personRequest.getCpf());
    }
}
