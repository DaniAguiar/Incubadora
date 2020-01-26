package com.invillia.api.domain.request;

import javax.validation.constraints.NotNull;

public class WithdrawRequest {

    @NotNull
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
