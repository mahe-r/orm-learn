package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Transactional
public interface CountryService {

	@Transactional(readOnly=true)
	public List<Country> getAllCountries();
	
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;
	
	public void addCountry(Country country);
	
	public void updateCountry(String code,String name);
	
	public void deleteCountry(String countryCode);
	
	public List<Country> getAllMatchingCountries(String partialName);
	
	public List<Country> getAllCountriesStartingWithLetter(char startingLetter);
}