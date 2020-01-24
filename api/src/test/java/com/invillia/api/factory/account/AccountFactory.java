package com.invillia.api.factory.account;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.api.domain.Account;
import com.invillia.api.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory extends JBacon<Account> {

    private final AccountRepository accountRepository;
    private final Faker faker;

    public AccountFactory(AccountRepository accountRepository, Faker faker) {
        this.accountRepository = accountRepository;
        this.faker = faker;
    }

    @Override
    protected Account getDefault(){
        final Account account = new Account();

        account.setBalance(faker.number().randomDouble(1, 1, 9999 ));
        account.setAccountLimit(faker.number().randomDouble(1, 1, 5000) );
        account.setMaxLimit(faker.number().randomDouble(1, 5000, 9999));

        return account;
    }

    @Override
    protected Account getEmpty() {
        return new Account();
    }

    @Override
    protected void persist(final Account account) {
        accountRepository.save(account);
    }

}
