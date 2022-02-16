package com.moduefinalexam.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Country country;
    private Double area;
    private long population;
    private double GDP;
    private String introduce;
}
