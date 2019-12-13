package com.invillia.api.domain.request;

import javax.validation.constraints.NotNull;

public class WithdrawRequest {

    @NotNull
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
