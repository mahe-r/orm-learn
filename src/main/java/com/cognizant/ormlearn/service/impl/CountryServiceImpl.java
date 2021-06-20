package com.cognizant.ormlearn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service("countryService")
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository repository;

	@Override
	public List<Country> getAllCountries() {
		return repository.findAll();
	}

	@Override
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = repository.findById(countryCode);
		
		if(!result.isPresent()) 
			throw new CountryNotFoundException("No Country found for code: " + countryCode);
		else
			return result.get();
		
	}

	@Override
	public void addCountry(Country country) {
		repository.save(country);
	}

	@Override
	public void updateCountry(String code, String name) {
		Country countryToBeUpdated = repository.findById(code).get();
		countryToBeUpdated.setName(name);
		repository.save(countryToBeUpdated);
	}

	@Override
	public void deleteCountry(String countryCode) {
		repository.deleteById(countryCode);
	}

	@Override
	public List<Country> getAllMatchingCountries(String partialName) {
		return repository.findCountriesByPartialName(partialName);
	}

	@Override
	public List<Country> getAllCountriesStartingWithLetter(char startingLetter) {
		return repository.findCountriesByStartingLetter(startingLetter);
	}
}