package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String registry;

    private String Phone;
}
