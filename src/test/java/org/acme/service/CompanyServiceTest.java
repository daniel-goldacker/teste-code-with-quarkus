package org.acme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.entity.CompanyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CompanyServiceTest {

    @Inject
    CompanyService companyService;

    private CompanyEntity companyEntity;

    @BeforeEach
    public void setupTeste(){
        companyEntity = new CompanyEntity();

        companyEntity.setName("teste company");
        companyEntity.setAddress("Rua xpto, 123");
        companyEntity.setRegistry("1234567");
        companyEntity.setPhone("47991457410");
    }

    @Test
    @TestTransaction
    public void testSaveCompany(){
        Assertions.assertEquals(Optional.of(companyEntity), companyService.saveCompany(companyEntity));
    }

    @Test
    @TestTransaction
    public void testErrorSaveCompany(){
        Assertions.assertEquals(Optional.empty(), companyService.saveCompany(null));
    }
    

    @Test
    @TestTransaction
    public void testGetCompany(){
        companyService.saveCompany(companyEntity);

        List<CompanyEntity> companyEntities = new ArrayList<>();
        companyEntities.add(companyEntity);

        Optional<List<CompanyEntity>> expected = Optional.of(companyEntities);
        Optional<List<CompanyEntity>> actual = Optional.of(companyEntities);

        Assertions.assertEquals(expected, actual);
    }
}
