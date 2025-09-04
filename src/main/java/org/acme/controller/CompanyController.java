package org.acme.controller;

import java.util.List;
import java.util.Optional;

import org.acme.entity.CompanyEntity;
import org.acme.service.CompanyService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/company")
public class CompanyController {

    @Inject
    CompanyService companyService;

    @POST
    @Transactional
    public Response saveUser(CompanyEntity companyEntity){
        Optional<CompanyEntity> saveCompany = companyService.saveCompany(companyEntity);

        if (saveCompany.isPresent()){
            return Response.ok(saveCompany.get()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @GET
    public Response findAllCompanies(){
        Optional<List<CompanyEntity>> companies = companyService.getCompanies();
        if (companies.isPresent()){
            return Response.ok(companies.get()).build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }    
        
    }

}
