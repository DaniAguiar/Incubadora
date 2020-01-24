package com.invillia.api.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonRequest {

    @NotBlank(message = "Name must be filled")
    private String name;

    @NotBlank(message = "CPF must be filled")
    private String cpf;
}
