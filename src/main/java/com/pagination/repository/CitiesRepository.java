package com.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagination.model.Cities;

public interface CitiesRepository extends JpaRepository<Cities, Integer> {

}
