package com.invillia.api.controller;

import com.invillia.api.domain.request.PersonRequest;
import com.invillia.api.domain.response.PersonResponse;
import com.invillia.api.service.PersonService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonResponse> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonResponse findById(@PathVariable final Long id){
        return personService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> create(@Valid @RequestBody final PersonRequest personRequest) {
        final Long id = personService.insert(personRequest);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/people/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id,
                                @Valid @RequestBody final PersonRequest personRequest){

        personService.update(id, personRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable final Long id){

        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
