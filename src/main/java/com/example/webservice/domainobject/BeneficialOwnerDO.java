package com.example.webservice.domainobject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "beneficialowner")
public class BeneficialOwnerDO {

    @Id
    @GeneratedValue
    @Column(name = "owner_id")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name of owner can't be null")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_owners",
            joinColumns = @JoinColumn(name = "owner_id", referencedColumnName = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id", referencedColumnName = "company_id"))
    private Set<CompanyDO> companies = new HashSet<>();

    public BeneficialOwnerDO() {
    }

    public BeneficialOwnerDO(@NotNull(message = "Name of owner can't be null") String name) {
        this.name = name;
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

    public Set<CompanyDO> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<CompanyDO> companies) {
        this.companies = companies;
    }
}
