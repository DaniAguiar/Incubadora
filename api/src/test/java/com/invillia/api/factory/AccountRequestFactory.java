package com.invillia.api.factory;

import br.com.leonardoferreira.jbacon.JBacon;
import com.github.javafaker.Faker;
import com.invillia.api.domain.request.AccountRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountRequestFactory extends JBacon<AccountRequest> {

    private final Faker faker;

    public AccountRequestFactory(Faker faker) {
        this.faker = faker;
    }

    @Override
    protected AccountRequest getDefault() {
        final AccountRequest accountRequest = new AccountRequest();

        accountRequest.setBalance(faker.number().randomDouble(1, 1, 9999 ));
        accountRequest.setAccountLimit(faker.number().randomDouble(1, 1, 5000) );
        accountRequest.setMaxLimit(faker.number().randomDouble(1, 5000, 9999));

        return accountRequest;
    }

    @Override
    protected AccountRequest getEmpty() {
        return new AccountRequest();
    }

    @Override
    protected void persist(final AccountRequest accountRequest) {
        throw new UnsupportedOperationException();
    }
}
