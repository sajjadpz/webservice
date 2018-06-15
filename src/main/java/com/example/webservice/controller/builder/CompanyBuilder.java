package com.example.webservice.controller.builder;

import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.dto.CompanyDTO;

public class CompanyBuilder {

    public static CompanyDTO buildCompanyDTO(CompanyDO companyDO) {
        return new CompanyDTO(
                companyDO.getId(),
                companyDO.getName(),
                companyDO.getAddress(),
                companyDO.getCity(),
                companyDO.getCountry(),
                companyDO.getEmail(),
                companyDO.getPhoneNumber());
    }

    public static CompanyDO buildCompanyDO(CompanyDTO companyDTO) {
        return new CompanyDO(
                companyDTO.getName(),
                companyDTO.getAddress(),
                companyDTO.getCity(),
                companyDTO.getCountry(),
                companyDTO.getEmail(),
                companyDTO.getPhoneNumber());
    }
}
