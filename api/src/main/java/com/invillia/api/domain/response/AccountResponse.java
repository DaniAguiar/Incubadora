package com.invillia.api.domain.response;

import lombok.Data;

@Data
public class AccountResponse {

    private Long id;
    private Double balance;
    private Double accountLimit;
    private Double maxLimit;
    private String createdAt;
    private String updatedAt;
    private PersonResponse person;
}
