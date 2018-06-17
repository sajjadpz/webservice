package com.example.webservice;

import com.example.webservice.controller.builder.CompanyBuilder;
import com.example.webservice.domainobject.BeneficialOwnerDO;
import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.dto.CompanyDTO;

import java.util.HashSet;
import java.util.Set;

public class CompanyTest {

    protected static CompanyDTO createCompany() {
        Set<BeneficialOwnerDO> beneficialOwners = new HashSet<>();
        beneficialOwners.add(new BeneficialOwnerDO("Simon"));
        CompanyDO companyDO = new CompanyDO("EXXON", "USA 10 Downtown str.", "NY", "USA", "exxon@abc.com", "998877000", beneficialOwners);
        CompanyDTO companyDTO = CompanyBuilder.buildCompanyDTO(companyDO);
        return companyDTO;
    }
}
