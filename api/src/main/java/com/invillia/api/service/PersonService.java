package com.invillia.api.service;

import com.invillia.api.domain.Person;
import com.invillia.api.domain.request.PersonRequest;
import com.invillia.api.domain.response.PersonResponse;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.mapper.PersonMapper;
import com.invillia.api.repository.PersonRepository;
import com.sun.istack.FinalArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Transactional(readOnly = true)
    public List<PersonResponse> findAll(){
        final List<Person> people = (List<Person>) personRepository.findAll();

        return personMapper.personToPersonResponse(people);
    }

    @Transactional(readOnly = true)
    public PersonResponse findById(final Long id){
        return personRepository.findById(id)
                .map(personMapper::personToPersonResponse)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public Long insert(final PersonRequest personRequest){
        Person person = personMapper.personRequestToPerson(personRequest);
        personRepository.save(person);

        return person.getId();
    }

    @Transactional
    public void update(final Long id, final PersonRequest personRequest){
        final Person person = personRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        personMapper.updatePersonToPersonRequest(person, personRequest);
        personRepository.save(person);
    }

    @Transactional
    public void delete(final Long id){
        final Person person = personRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        personRepository.delete(person);
    }
}
