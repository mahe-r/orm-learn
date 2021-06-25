package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Autowired
	CountryService countryService;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	SkillService skillService;
	
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}
	
	@Bean
	CommandLineRunner testGetAllCountries() {
		return args -> {
			LOGGER.info("START");
			List<Country> countries = countryService.getAllCountries();
			LOGGER.debug("countries = {}", countries);
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner testGetCountryById() {
		return args -> {
			LOGGER.info("START");
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("country = {}", country);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testAddCountry() {
		return args -> {
			LOGGER.info("START");
			Country country = new Country();
			country.setCode("AB");
			country.setName("Arshadri");
			countryService.addCountry(country);
			LOGGER.debug("country = {}", country);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testUpdateCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.updateCountry("AB", "Arsdri");
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testDeleteCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.deleteCountry("AB");
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAllMatchingCountries() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("countries = {}", countryService.getAllMatchingCountries("ou"));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAllCountriesStartingWithLetter() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("countries = {}", countryService.getAllCountriesStartingWithLetter('z'));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAllStocks() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.getAllStocks();
			LOGGER.debug("stocks = {}", stocks);
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner testGetStocksOfFBInSep2019() {
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
	CommandLineRunner testGetStocksOfGoogleGT1250() {
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
	CommandLineRunner testGetTop3StocksByVolume() {
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
	CommandLineRunner test3LowestNetflixStocks() {
		return args -> {
			LOGGER.info("START");
			List<Stock> stocks = stockService.get3LowestNetflixStocks();
			for(Stock stock: stocks) {
				LOGGER.debug("stocks = {}",stock);
			}
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.get(1);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Department:{}", employee.getDepartment());
			LOGGER.debug("Skills:{}",employee.getSkillList());
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testAddEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = new Employee();
			employee.setName("Smith");
			employee.setSalary(new BigDecimal(9000.0));
			employee.setPermanent(true);
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			employee.setDateOfBirth(ft.parse("2000-07-03"));
			Department department = departmentService.get(1);
			employee.setDepartment(department);
			employeeService.save(employee);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testUpdateEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.get(7);
			Department department = departmentService.get(4);
			employee.setDepartment(department);
			employeeService.save(employee);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.info("END");
		};
	}	
	
	@Bean
	CommandLineRunner testGetDepartment() {
		return args -> {
			LOGGER.info("START");
			Department department = departmentService.get(3);
			LOGGER.debug("Department:{}",department);
			department.getEmployeeList().forEach(employee -> LOGGER.debug("{}", employee));
			LOGGER.info("END");
		};	
	}
	
	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.get(4);
			Skill skill = skillService.get(3);
			employee.getSkillList().add(skill);
			employeeService.save(employee);
			LOGGER.debug("Employee:{}",employee);
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAllPermanentEmployees() {
		return args -> {
			LOGGER.info("START");
			List<Employee> employees = employeeService.getAllPermanentEmployees();
			LOGGER.debug("Permanent Employees:{}",employees);
			employees.forEach(employee -> LOGGER.debug("Skills:{}", employee.getSkillList()));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAverageSalary() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("Average Salary: {}",employeeService.getAverageSalary(2));
			LOGGER.info("END");
		};
	}
	
	@Bean
	CommandLineRunner testGetAllEmployeesNative() {
		return args -> {
			LOGGER.info("START");
			List<Employee> employees = employeeService.getAllEmployeesNative();
			employees.forEach(employee -> LOGGER.debug("Employee: {}",employee));
			LOGGER.info("END");
		};
	}
}