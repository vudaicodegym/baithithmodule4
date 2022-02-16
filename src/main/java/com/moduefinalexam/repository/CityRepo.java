package com.moduefinalexam.repository;

import com.moduefinalexam.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepo extends PagingAndSortingRepository<City, Integer> {
}
