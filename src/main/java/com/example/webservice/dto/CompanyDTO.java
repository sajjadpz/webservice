package com.example.webservice.dto;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class CompanyDTO {

    private Long id;

    @NotNull(message = "Company name cannot be null")
    private String name;

    @NotNull(message = "Company address cannot be null")
    private String address;

    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "Country cannot be null")
    private String country;

    private String email;

    private String phoneNumber;

    private Set<BeneficialOwnerDTO> beneficialOwners;

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, @NotNull(message = "Company name cannot be null") String name, @NotNull(message = "Company address cannot be null") String address, @NotNull(message = "City cannot be null") String city, @NotNull(message = "Country cannot be null") String country, String email, String phoneNumber, Set<BeneficialOwnerDTO> beneficialOwners) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.beneficialOwners = beneficialOwners;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<BeneficialOwnerDTO> getBeneficialOwners() {
        return beneficialOwners;
    }
}
