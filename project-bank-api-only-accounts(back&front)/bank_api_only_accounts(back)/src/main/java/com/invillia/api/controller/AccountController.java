package com.invillia.api.controller;

import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.domain.request.WithdrawRequest;
import com.invillia.api.domain.response.AccountResponse;
import com.invillia.api.service.AccountService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable final Long id){
        return accountService.findById(id);
    }

    @PostMapping
    public HttpEntity<?> create(@Valid @RequestBody final AccountRequest accountRequest){
        final Long id = accountService.insert(accountRequest);

        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/accounts/{id}").build(id);

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id,
                                @Valid @RequestBody final AccountRequest accountRequest){
        accountService.update(id, accountRequest);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable final Long id){
        accountService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/withdraws/{id}")
    public HttpEntity<?> doWithdraw(@PathVariable Long id,
                                    @Valid @RequestBody WithdrawRequest req){

        accountService.getIdAccountRequestToWithdraw(id, req.getValue());

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deposits/{id}")
    public HttpEntity<?> doDeposit(@PathVariable Long id,
                                   @Valid @RequestBody WithdrawRequest req){

        accountService.getIdAccountRequestToDeposit(id, req.getValue());

        return ResponseEntity.noContent().build();
    }

}
