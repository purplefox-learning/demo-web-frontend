package com.ycm.demo;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Repository
public class CountryDao {

	private final String resourceUrl;
	private final RestTemplate restTemplate;

	@Autowired
	public CountryDao(RestTemplate restTemplate, @Value("${demo.integrator.url}") String providerUrl) {
		this.restTemplate = restTemplate;
		this.resourceUrl = providerUrl + "/countries";
	}

	public List<Country> getAllCountries() {
		log.info("[Frontend] CoutryDao is about to getAllCountries()...");
		List<Country> countryList = restTemplate.getForObject(resourceUrl, List.class);
		return countryList;
	}

	public Country getCountry(String countryCode) {
        log.info("[Frontend] CoutryDao is about to getCountry()...");
		String url = resourceUrl + "/" + countryCode;
		Country country = restTemplate.getForObject(url, Country.class);
		return country;
	}
}
