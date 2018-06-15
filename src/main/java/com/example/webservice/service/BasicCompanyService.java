package com.example.webservice.service;

import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.repository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicCompanyService implements CompanyService {

    private final CompanyRespository companyRespository;

    @Autowired
    public BasicCompanyService(CompanyRespository companyRespository) {
        this.companyRespository = companyRespository;
    }

    @Override
    public CompanyDO create(CompanyDO companyDO) {
        return companyRespository.save(companyDO);
    }

    @Override
    public Iterable<CompanyDO> findAllCompanies() {
        return companyRespository.findAll();
    }
}
