package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.CountryRepository.CountryRepository;
import com.cognizant.ormlearn.model.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	@Transactional
	 public List<Country> getAllCountries(){
		 List<Country> countriesList = countryRepository.findAll();
		 return countriesList;
	 }
	
}