package com.invillia.api.mapper;

import com.invillia.api.domain.Account;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.domain.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public AccountResponse accountToAccountResponse(final Account account){
        final AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId(account.getId());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setAccountLimit(account.getAccountLimit());
        accountResponse.setMaxLimit(account.getMaxLimit());
        accountResponse.setCreatedAt(account.getCreatedAt().format(formatter));
        accountResponse.setUpdatedAt(account.getUpdatedAt().format(formatter));

        return accountResponse;
    }

    public List<AccountResponse> accountToAccountResponse(final List<Account> accounts) {
        return accounts.stream()
                .map(this::accountToAccountResponse)
                .collect(Collectors.toList());
    }

    public Account accountRequestToAccount(final AccountRequest accountRequest){
        final Account account = new Account();

        account.setBalance(accountRequest.getBalance());
        account.setAccountLimit(accountRequest.getAccountLimit());
        account.setMaxLimit(accountRequest.getMaxLimit());

        return account;
    }

    public void updateAccountByAccountRequest(final Account account, final AccountRequest accountRequest){
        account.setBalance(accountRequest.getBalance());
        account.setAccountLimit(accountRequest.getAccountLimit());
        account.setMaxLimit(accountRequest.getMaxLimit());
    }
}
