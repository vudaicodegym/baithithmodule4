package com.moduefinalexam.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Country {
    @Id
    private int idCountry;
    private String countryName;
}
