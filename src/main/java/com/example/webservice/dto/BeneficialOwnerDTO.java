package com.example.webservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class BeneficialOwnerDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Name of Beneficial owner can't be null")
    private String name;

    public BeneficialOwnerDTO() {
    }

    public BeneficialOwnerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
