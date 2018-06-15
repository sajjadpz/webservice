package com.example.webservice.service;

import com.example.webservice.domainobject.CompanyDO;

public interface CompanyService {

    // TODO: 15/06/2018 Add exception handling
    CompanyDO create(CompanyDO companyDO);

    Iterable<CompanyDO> findAllCompanies();

}
