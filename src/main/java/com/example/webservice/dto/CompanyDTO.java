package com.example.webservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

public class CompanyDTO {

    @JsonIgnore
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

    public CompanyDTO() {
    }

    public CompanyDTO(Long id, @NotNull(message = "Company name cannot be null") String name, @NotNull(message = "Company address cannot be null") String address, @NotNull(message = "City cannot be null") String city, @NotNull(message = "Country cannot be null") String country, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
}
