package com.example.webservice.service;

import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.repository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Provides business logic for company related operations
 */
@Service
public class BasicCompanyService implements CompanyService {

    private final CompanyRespository companyRespository;

    @Autowired
    public BasicCompanyService(CompanyRespository companyRespository) {
        this.companyRespository = companyRespository;
    }

    /**
     * Creates new company
     *
     * @param companyDO
     * @return
     */
    @Override
    public CompanyDO create(CompanyDO companyDO) {
        return companyRespository.save(companyDO);
    }

    /**
     * Finds list of all created companies
     *
     * @return List of companies
     */
    @Override
    public Iterable<CompanyDO> findAllCompanies() {
        return companyRespository.findAll();
    }

    /**
     * Updates company information
     *
     * @param id
     * @param updatedCompany
     */
    @Override
    @Transactional
    public void updateCompany(long id, CompanyDO updatedCompany) {
        CompanyDO companyDO = companyRespository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));

        companyDO.setAddress(updatedCompany.getAddress());
        companyDO.setCity(updatedCompany.getCity());
        companyDO.setCountry(updatedCompany.getCountry());
        companyDO.setEmail(updatedCompany.getEmail());
        companyDO.setName(updatedCompany.getName());
        companyDO.setPhoneNumber(updatedCompany.getPhoneNumber());
        companyDO.setBeneficialOwnerDOS(updatedCompany.getBeneficialOwnerDOS());

    }

    /**
     * Find details of a specific company
     *
     * @param id
     * @return company details
     */
    @Override
    public CompanyDO findCompanyDetails(long id) {
        return companyRespository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }

    /**
     * Adds beneficial owner to existing company
     *
     * @param id
     * @param updatedCompany
     */
    @Override
    @Transactional
    public void addBeneficialOwner(long id, CompanyDO updatedCompany) {
        CompanyDO companyDO = companyRespository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
        if (companyDO.getBeneficialOwnerDOS() != null)
            companyDO.getBeneficialOwnerDOS().addAll(updatedCompany.getBeneficialOwnerDOS());
        else companyDO.setBeneficialOwnerDOS(updatedCompany.getBeneficialOwnerDOS());
    }
}
