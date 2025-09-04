package org.acme.repository;

import org.acme.entity.CompanyEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<CompanyEntity> {

}
