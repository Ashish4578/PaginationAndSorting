package com.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pagination.model.Cities;
import com.pagination.repository.CitiesRepository;

@Service
public class CitiesService {

	@Autowired
	private CitiesRepository paginationRepository;

	public List<Cities> getAllCities() {
		List<Cities> cities = paginationRepository.findAll();
		return cities;
	}

	public Page<Cities> getCities(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return paginationRepository.findAll(pageable);
	}

	public Page<Cities> getCitiesNameAndDescPopulation(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size,
				Sort.by("name").ascending().and(Sort.by("population").descending()));
		return paginationRepository.findAll(pageable);
	}
}
