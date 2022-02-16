package com.moduefinalexam.service;

import com.moduefinalexam.model.Country;
import com.moduefinalexam.repository.CityRepo;
import com.moduefinalexam.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService implements  ICountryService{
    @Autowired
    CountryRepo countryRepo;
    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepo.findAll();
    }
}
