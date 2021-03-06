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

/**
 * Provides endpoints to perform company related operations
 */
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(@Valid @PathVariable long id, @RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(id, CompanyBuilder.buildCompanyDO(companyDTO));
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyDetails(@Valid @PathVariable long id) {
        return CompanyBuilder.buildCompanyDTO(companyService.findCompanyDetails(id));
    }

    @PutMapping("/{id}/addBO")
    @ResponseStatus(HttpStatus.OK)
    public void addBeneficialOwner(@Valid @PathVariable long id, @RequestBody CompanyDTO companyDTO) {
        companyService.addBeneficialOwner(id, CompanyBuilder.buildCompanyDO(companyDTO));
    }
}
