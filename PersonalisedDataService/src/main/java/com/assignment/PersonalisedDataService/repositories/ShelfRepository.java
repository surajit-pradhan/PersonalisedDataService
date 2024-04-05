package com.assignment.PersonalisedDataService.repositories;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.PersonalisedDataService.entity.Shelf;
import com.assignment.PersonalisedDataService.entity.ShelfKey;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, ShelfKey> {
	
	@Cacheable(key="#shopperId",value="'shopper'")
	public List<Shelf> findByShopperId(String shopperId);
	
}
