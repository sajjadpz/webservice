package com.example.webservice.controller;

import com.example.webservice.controller.builder.CompanyBuilder;
import com.example.webservice.domainobject.CompanyDO;
import com.example.webservice.dto.CompanyDTO;
import com.example.webservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDTO createCompany(@Valid @RequestBody CompanyDTO companyDTO) {

        CompanyDO companyDO = CompanyBuilder.buildCompanyDO(companyDTO);
        return CompanyBuilder.buildCompanyDTO(companyService.create(companyDO));
    }


    @GetMapping
    public List<CompanyDTO> getCompanies() {
        return StreamSupport
                .stream(companyService.findAllCompanies().spliterator(), false)
                .map(CompanyBuilder::buildCompanyDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public void updateCompany(@Valid @PathVariable long id, @RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(id, CompanyBuilder.buildCompanyDO(companyDTO));
    }
}
