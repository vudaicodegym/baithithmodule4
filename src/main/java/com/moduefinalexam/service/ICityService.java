package com.moduefinalexam.service;

import com.moduefinalexam.model.City;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICityService {
    void saveCity(City city);
    void deleteCity(int id);
    List<City> fndAll();
    City findById(int id);
//    @Query(nativeQuery = true, value = "select * from city where id")
//    List<City> findByCountry(int idCountry);
}
