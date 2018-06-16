package com.example.webservice.controller.builder;

import com.example.webservice.domainobject.BeneficialOwnerDO;
import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.dto.BeneficialOwnerDTO;
import com.example.webservice.dto.CompanyDTO;

import java.util.HashSet;
import java.util.Set;

public class CompanyBuilder {

    public static CompanyDTO buildCompanyDTO(CompanyDO companyDO) {
        return new CompanyDTO(
                companyDO.getId(),
                companyDO.getName(),
                companyDO.getAddress(),
                companyDO.getCity(),
                companyDO.getCountry(),
                companyDO.getEmail(),
                companyDO.getPhoneNumber(),
                makeBeneficialOwnerDTO(companyDO.getBeneficialOwnerDOS())
        );
    }

    public static CompanyDO buildCompanyDO(CompanyDTO companyDTO) {
        return new CompanyDO(
                companyDTO.getName(),
                companyDTO.getAddress(),
                companyDTO.getCity(),
                companyDTO.getCountry(),
                companyDTO.getEmail(),
                companyDTO.getPhoneNumber(),
                makeBeneficialOwnerDO(companyDTO.getBeneficialOwners()));
    }

    private static Set<BeneficialOwnerDTO> makeBeneficialOwnerDTO(Set<BeneficialOwnerDO> beneficialOwnerDO) {
        Set<BeneficialOwnerDTO> beneficialOwnerDTOS = new HashSet<>();
        beneficialOwnerDO.stream().forEach(bo -> beneficialOwnerDTOS.add(new BeneficialOwnerDTO(bo.getId(), bo.getName())));
        return beneficialOwnerDTOS;
    }

    private static Set<BeneficialOwnerDO> makeBeneficialOwnerDO(Set<BeneficialOwnerDTO> beneficialOwnerDTO) {
        Set<BeneficialOwnerDO> beneficialOwnerDOs = new HashSet<>();
        beneficialOwnerDTO.stream().forEach(bo -> beneficialOwnerDOs.add(new BeneficialOwnerDO(bo.getName())));
        return beneficialOwnerDOs;
    }
}
