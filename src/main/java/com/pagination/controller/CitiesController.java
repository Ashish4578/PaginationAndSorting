package com.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.model.Cities;
import com.pagination.service.CitiesService;

@RestController
public class CitiesController {

	@Autowired
	private CitiesService paginationService;

	@GetMapping("/")
	public List<Cities> getAllCitiesDetails() {
		return paginationService.getAllCities();
	}

	@GetMapping("/cities")
	public Page<Cities> getPaginatedCities(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
		return paginationService.getCities(page, size, sortBy);
	}

	//Serializing PageImpl instances as-is is not supported, meaning that there is no guarantee about the stability of the resulting JSON structure!
//	For a stable JSON structure, please use Spring Data's PagedModel (globally via @EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO))
//	or Spring HATEOAS and Spring Data's PagedResourcesAssembler as documented in https://docs.spring.io/spring-data/commons/reference/repositories/core-extensions.html#core.web.pageables.

	@GetMapping("/cities/sort")
	public Page<Cities> getPaginatedCitiesByNameAndDescPopulaatoin(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
		return paginationService.getCitiesNameAndDescPopulation(page, size, sortBy);
	}
}
