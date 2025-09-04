package org.acme.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.acme.entity.CompanyEntity;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class CompanyControllerTest {

    @Test
    public void testSaveCompanyEndpoint() throws Exception{

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("teste company");
        companyEntity.setAddress("Rua xpto, 123");
        companyEntity.setRegistry("1234567");
        companyEntity.setPhone("47991457410");

        RestAssured
            .given()
            .contentType("application/json")
            .body(companyEntity)
            .when()
            .post("/company")
            .then()
            .statusCode(200)
            .body("name", equalTo("teste company"))
            .body("address", equalTo("Rua xpto, 123"))
            .body("registry", equalTo("1234567"))
            .body("phone", equalTo("47991457410"));
    }

    @Test
    public void testFindAllCompanyEndpoint() throws Exception{
        RestAssured
            .when()
            .get("/company")
            .then()
            .statusCode(200)
            .body("size()", greaterThanOrEqualTo(0));
    }



}
