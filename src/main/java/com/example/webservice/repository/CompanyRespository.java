package com.example.webservice.repository;

import com.example.webservice.domainobject.CompanyDO;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRespository extends CrudRepository<CompanyDO, Long> {
}
