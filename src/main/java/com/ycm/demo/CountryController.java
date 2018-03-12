package com.ycm.demo;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	private final CountryDao dao;

	@Autowired
	public CountryController(CountryDao dao) {
		this.dao = dao;
	}

	@GetMapping(value = "/mycountries", produces = APPLICATION_JSON_VALUE)
	public List<Country> getCountries() {
		List<Country> countryList = dao.getAllCountries();
		return countryList;
	}

	@GetMapping(value = "/mycountries/{countryCode}", produces = APPLICATION_JSON_VALUE)
	public Country getCountryByCode(@PathVariable("countryCode") String countryCode) {
		Country country = dao.getCountry(countryCode);
		return country;
	}
}
