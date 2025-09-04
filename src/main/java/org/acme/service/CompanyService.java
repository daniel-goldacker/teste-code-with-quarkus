package org.acme.service;

import java.util.List;
import java.util.Optional;

import org.acme.entity.CompanyEntity;
import org.acme.repository.CompanyRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompanyService {
    @Inject
    CompanyRepository companyRepository;

    public Optional<CompanyEntity> saveCompany(CompanyEntity newCompanyEntity){

        try {
            companyRepository.persist(newCompanyEntity);
            int listSize = companyRepository.listAll().size();
            CompanyEntity savedCompany = companyRepository.listAll().get(listSize-1);
            return Optional.of(savedCompany); 
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public Optional<List<CompanyEntity>> getCompanies(){
        return Optional.of(companyRepository.findAll().list());
    }
}
