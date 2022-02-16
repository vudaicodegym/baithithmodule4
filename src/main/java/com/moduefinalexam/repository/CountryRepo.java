package com.moduefinalexam.repository;

import com.moduefinalexam.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepo extends PagingAndSortingRepository<Country, Integer> {
}
