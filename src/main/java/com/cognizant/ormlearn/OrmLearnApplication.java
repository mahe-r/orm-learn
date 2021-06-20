package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Autowired
	CountryService countryService;
	
	@Autowired
	StockService stockService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}
	
	@Bean
	CommandLineRunner getAllCountries() {
		return args -> {
			LOGGER.info("START");
			List<Country> countries = countryService.getAllCountries();
			LOGGER.debug("countries = {}", countries);
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner getCountryById() {
		return args -> {
			LOGGER.info("START");
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("countries = {}", country);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner addCountry() {
		return args -> {
			LOGGER.info("START");
			Country country = new Country();
			country.setCode("AB");
			country.setName("Arshadri");
			countryService.addCountry(country);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner updateCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.updateCountry("AB", "Arsdri");
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner deleteCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.deleteCountry("AB");
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner getAllMatchingCountries() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("countries = {}", countryService.getAllMatchingCountries("ou"));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner getAllCountriesStartingWithLetter() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("countries = {}", countryService.getAllCountriesStartingWithLetter('z'));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner getAllStocks() {
		return args -> {
			LOGGER.info("START.");
			List<Stock> stocks = stockService.getAllStocks();
			LOGGER.debug("stocks = {}", stocks);
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner getStocksOfFBInSep2019() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.getStocksOfFBInSep2019();
			for(Stock stock: stocks){
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner getStocksOfGoogleGT1250() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.getStocksOfGoogleGT1250();
			for(Stock stock: stocks){
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner getTop3StocksByVolume() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.getTop3StocksByVolume();
			for(Stock stock: stocks){
				LOGGER.debug("stocks = {}", stock);
			}
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner get3LowestNetflixStocks() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.get3LowestNetflixStocks();
			for(Stock stock: stocks) {
				LOGGER.debug("stocks = {}",stock);
			}
			LOGGER.info("END");
		};
	}

}