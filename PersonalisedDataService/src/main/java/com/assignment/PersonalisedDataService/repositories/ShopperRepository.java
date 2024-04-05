package com.assignment.PersonalisedDataService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.PersonalisedDataService.entity.Shopper;

@Repository
public interface ShopperRepository extends JpaRepository<Shopper, String> {

	
	
}

