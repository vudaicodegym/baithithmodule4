package com.moduefinalexam.controller;

import com.moduefinalexam.model.City;
import com.moduefinalexam.model.Country;
import com.moduefinalexam.service.ICityService;
import com.moduefinalexam.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    ICityService cityService;
    @Autowired
    ICountryService countryService;
    @GetMapping
    public ResponseEntity<List<City>> showAll(){
        return new ResponseEntity<>(cityService.fndAll(), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<City> detailCity(@PathVariable int id){
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCity(@PathVariable int id){
        cityService.deleteCity(id);
        return new ResponseEntity (HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> createCity(@RequestBody City city){
        cityService.saveCity(city);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit{id}")
    public ResponseEntity<?> edited(@RequestBody City city, @PathVariable int id){
        city.setId(id);
        cityService.saveCity(city);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/country")
    public ResponseEntity<List<Country>> getAllCountry(){
        return new ResponseEntity<>( countryService.findAll(), HttpStatus.OK);
    }
}
