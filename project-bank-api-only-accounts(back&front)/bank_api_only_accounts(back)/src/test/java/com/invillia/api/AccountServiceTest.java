package com.invillia.api;


import com.invillia.api.domain.Account;
import com.invillia.api.mapper.AccountMapper;
import com.invillia.api.repository.AccountRepository;
import com.invillia.api.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class AccountServiceTest {

    private Account account;
    private AccountService accountService;
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @BeforeEach
    void setUp(){
        accountRepository = Mockito.mock(AccountRepository.class);
        account = new Account( 1000.00, 500.00,500.00);
        accountService = new AccountService(accountRepository, accountMapper);
    }

    @Test
    void successfulWithdrawTest(){
        accountService.withdraw(account, 100.00);

        Assertions.assertEquals(900.00, account.getBalance());

        final ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
        Mockito.verify(accountRepository, Mockito.times(1)).save(captor.capture());

        Assertions.assertEquals(account.getBalance(), captor.getValue().getBalance());
    }

    @Test
    void withdrawalWithoutLimitTest(){
        accountService.withdraw(account, 2000.00);

        Assertions.assertEquals(1000.00, account.getBalance());
    }

    @Test
    void successfulDepositTest(){
        accountService.deposit(account, 100.00);

        Assertions.assertEquals(1000.00, account.getBalance());

        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
        Mockito.verify(accountRepository, Mockito.times(1)).save(captor.capture());

        Assertions.assertEquals(account.getBalance(), captor.getValue().getBalance());
    }

    @Test
    void depositWithoutLimitTest(){
        accountService.deposit(account, -1000.00);

        Assertions.assertEquals(1000.00, account.getBalance());
    }
}
