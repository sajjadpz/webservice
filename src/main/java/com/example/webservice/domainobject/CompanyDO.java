package com.example.webservice.domainobject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "company")
public class CompanyDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Company name cannot be null")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Company address cannot be null")
    private String address;

    @Column(nullable = false)
    @NotNull(message = "City cannot be null")
    private String city;

    @Column(nullable = false)
    @NotNull(message = "Country cannot be null")
    private String country;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    // TODO: 15/06/2018 Add Beneficial Owner

    private CompanyDO() {
    }

    public CompanyDO(@NotNull(message = "Company name cannot be null") String name, @NotNull(message = "Company address cannot be null") String address, @NotNull(message = "City cannot be null") String city, @NotNull(message = "Country cannot be null") String country, String email, String phoneNumber) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
