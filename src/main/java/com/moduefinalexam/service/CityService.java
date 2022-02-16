package com.moduefinalexam.service;

import com.moduefinalexam.model.City;
import com.moduefinalexam.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService implements ICityService{
    @Autowired
    CityRepo cityRepo;

    @Override
    public void saveCity(City city) {
        cityRepo.save(city);
    }

    @Override
    public void deleteCity(int id) {
        cityRepo.deleteById(id);
    }

    @Override
    public List<City> fndAll() {
        return (List<City>) cityRepo.findAll();
    }

    @Override
    public City findById(int id) {
        return cityRepo.findById(id).get();
    }
}
