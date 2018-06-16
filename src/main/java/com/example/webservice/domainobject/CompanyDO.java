package com.example.webservice.domainobject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class CompanyDO {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "company_owners",
            joinColumns = {@JoinColumn(name = "company_id", referencedColumnName = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "owner_id", referencedColumnName = "owner_id")})
    private Set<BeneficialOwnerDO> beneficialOwnerDOS = new HashSet<>();

    private CompanyDO() {
    }

    public CompanyDO(@NotNull(message = "Company name cannot be null") String name, @NotNull(message = "Company address cannot be null") String address, @NotNull(message = "City cannot be null") String city, @NotNull(message = "Country cannot be null") String country, String email, String phoneNumber, Set<BeneficialOwnerDO> beneficialOwnerDOS) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.beneficialOwnerDOS = beneficialOwnerDOS;
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

    public Set<BeneficialOwnerDO> getBeneficialOwnerDOS() {
        return beneficialOwnerDOS;
    }

    public void setBeneficialOwnerDOS(Set<BeneficialOwnerDO> beneficialOwnerDOS) {
        this.beneficialOwnerDOS = beneficialOwnerDOS;
    }
}
