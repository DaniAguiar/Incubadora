package com.invillia.api.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountRequest {

    @NotNull(message = "Balance can't be null")
    private Double balance;

    @NotNull(message = "Limit can't be null")
    private Double accountLimit;

    @NotNull(message = "Max Limit can't be null")
    private Double maxLimit;
}
