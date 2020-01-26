package com.invillia.api.service;

import com.invillia.api.domain.Account;
import com.invillia.api.domain.request.AccountRequest;
import com.invillia.api.domain.response.AccountResponse;
import com.invillia.api.exception.ResourceNotFoundException;
import com.invillia.api.mapper.AccountMapper;
import com.invillia.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional(readOnly = true)
    public List<AccountResponse> findAll() {
        final List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accountMapper.accountToAccountResponse(accounts);
    }

    @Transactional(readOnly = true)
    public AccountResponse findById(final Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::accountToAccountResponse)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Long insert(final AccountRequest accountRequest){
        Account account = accountMapper.accountRequestToAccount(accountRequest);
        accountRepository.save(account);

        return account.getId();
    }


    @Transactional
    public void update(final Long id, final AccountRequest accountRequest) {

        final Account account = accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        accountMapper.updateAccountByAccountRequest(account, accountRequest);
        accountRepository.save(account);
    }

    @Transactional
    public void delete(final Long id){
        final Account account = accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        accountRepository.delete(account);
    }

    @Transactional
    public void withdraw(final Account account, double value){

        if (account.getBalance() + account.getAccountLimit() - value < 0) {
            System.out.println("Saque negado!\nValor de limite ultrapassado.\nSaque novamente com um valor menor");
        } else if (account.getBalance() >= value) {
            account.setBalance(account.getBalance() - value);
        } else {
            account.setBalance(account.getBalance() - value);
            account.setAccountLimit(account.getAccountLimit() + account.getBalance());
            account.setBalance(0D);

        }
        accountRepository.save(account);
    }

    @Transactional
    public void deposit(final Account account, double value){

        if(value > 0.0){

            System.out.println("\nValor limites da função: "+ account.getAccountLimit() +"\n");
            System.out.println("\nValor do saldo dentro da função: "+ account.getBalance() +"\n");
            System.out.println("\nValor limite maximo: "+ account.getMaxLimit() +"\n");

            if(account.getAccountLimit().equals(account.getMaxLimit())){
                account.setBalance(account.getBalance() + value);
                System.out.println("\nValor dentro da função: "+ value +"\n");
                System.out.println("\nValor do novo saldo dentro da função: "+ account.getBalance() +"\n");
            }
            else if(account.getMaxLimit() > account.getAccountLimit()){
                double limitDifference = account.getMaxLimit() - account.getAccountLimit();

                if(value <= limitDifference){
                    account.setAccountLimit(account.getAccountLimit() + value);
                }
                else{
                    account.setAccountLimit( account.getAccountLimit() + limitDifference);
                    value -= limitDifference;
                    account.setBalance( account.getBalance() + value);
                }
            }
            accountRepository.save(account);
            System.out.println("\nValor : "+ value +"\n");
            System.out.println("\nValor do novo saldo : "+ account.getBalance() +"\n");

        }
        else System.out.println("\nValor de depósito precisa ser maior que R$0.0\n");
    }

    @Transactional
    public void getIdAccountRequestToWithdraw(final Long id, double value){

        final Account account = accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        withdraw(account, value);
    }

    @Transactional
    public void getIdAccountRequestToDeposit(final Long id, double value){

        final Account account = accountRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        deposit(account, value);
    }
}
