package com.assignment.PersonalisedDataService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.PersonalisedDataService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	
	
}
