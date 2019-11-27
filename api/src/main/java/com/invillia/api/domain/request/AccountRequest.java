package com.invillia.api.domain.request;

import javax.validation.constraints.NotNull;

public class AccountRequest {

    @NotNull
    private Double balance;

    @NotNull
    private Double accountLimit;

    @NotNull
    private Double maxLimit;

    public Double getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(Double accountLimit) {
        this.accountLimit = accountLimit;
    }
}
