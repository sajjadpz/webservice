package com.example.webservice;

import com.example.webservice.dto.BeneficialOwnerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.collection.IsMapContaining;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = WebserviceApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:test_data.sql")
public class CompanyControllerIT extends CompanyTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getCompanyDetails_whenCompanyInfoFetched_thenReturnCompanyInformation() throws Exception {
        Long companyId = 1001L;
        mockMvc.perform(
                get("/companies/" + companyId)
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("BMW")))
                .andExpect(jsonPath("$.address", is("Berlin warburg str.22001")))
                .andExpect(jsonPath("$.city", is("Berlin")))
                .andExpect(jsonPath("$.country", is("Germany")))
                .andExpect(jsonPath("$.email", is("bmw@xyz.de")))
                .andExpect(jsonPath("$.phoneNumber", is("9988083727")));
    }

    @Test
    public void createCompany_whenCreateCompany_thenReturnCompanyInformation() throws Exception {
        String companyData = objectMapper.writeValueAsString(createCompany());
        mockMvc.perform(post("/companies")
                .content(companyData)
                .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isCreated())

                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("EXXON")))
                .andExpect(jsonPath("$.address", is("USA 10 Downtown str.")))
                .andExpect(jsonPath("$.city", is("NY")))
                .andExpect(jsonPath("$.country", is("USA")))
                .andExpect(jsonPath("$.email", is("exxon@abc.com")))
                .andExpect(jsonPath("$.phoneNumber", is("998877000")));
    }
}
