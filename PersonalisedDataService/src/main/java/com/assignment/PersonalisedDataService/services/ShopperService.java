package com.assignment.PersonalisedDataService.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.PersonalisedDataService.entity.Product;
import com.assignment.PersonalisedDataService.entity.Shelf;
import com.assignment.PersonalisedDataService.entity.Shopper;
import com.assignment.PersonalisedDataService.model.ProductDto;
import com.assignment.PersonalisedDataService.model.ShelfDto;
import com.assignment.PersonalisedDataService.model.ShopperDto;
import com.assignment.PersonalisedDataService.repositories.ProductRepository;
import com.assignment.PersonalisedDataService.repositories.ShelfRepository;
import com.assignment.PersonalisedDataService.repositories.ShopperRepository;
import com.assignment.PersonalisedDataService.util.ModelMapper;

@Service
public class ShopperService {

	@Autowired
	ShopperRepository shopperRepository;

	@Autowired
	ShelfRepository shelfRepository;

	@Autowired
	ProductRepository productRepository;

	public void importShoppers(Set<ShopperDto> shoppers) {
		Set<String> products = productRepository.findAll().stream().map(Product::getId).collect(Collectors.toSet());
		Set<Shopper> shopperEntities = shoppers.stream().map(ModelMapper::getShopperEntity).collect(Collectors.toSet());
		shopperRepository.saveAll(shopperEntities);
		Set<Shelf> shelves = shoppers.stream().flatMap(dto -> ModelMapper.getShelfEntities(dto).stream())
				.filter(s -> products.contains(s.getId().getProductId())).collect(Collectors.toSet());
		shelfRepository.saveAll(shelves);
	}

	public ShopperDto getShopperProducts(String shopperId) {
		List<Shelf> shelves = shelfRepository.findByShopperId(shopperId);
		Set<ShelfDto> ss = shelves.stream().map(ModelMapper::getShelfDto).collect(Collectors.toSet());
		return ShopperDto.builder().shopperId(shopperId).shelf(ss).build();
	}

	public List<ProductDto> getPersonalisedProducts(Optional<String> shopperId, Optional<Set<String>> categories,
			Optional<Set<String>> brands, Optional<Set<Double>> priceRange, Optional<String> sortBy,
			Optional<String> sortType, Optional<Integer> page, Optional<Integer> pageSize) {
		List<Shelf> shelves = shelfRepository.findByShopperId(shopperId.get());
		if (categories.isPresent())
			shelves = shelves.stream().filter(shelf -> categories.get().contains(shelf.getProduct().getCategory()))
					.toList();
		if (brands.isPresent())
			shelves = shelves.stream().filter(shelf -> brands.get().contains(shelf.getProduct().getBrand())).toList();
		if (sortBy.isPresent()) {
			if (sortBy.get().equalsIgnoreCase("RELEVANCYSCORE")) {
				if (sortType.isEmpty() || sortType.get().equalsIgnoreCase("ASC"))
					shelves = shelves.stream().sorted(Comparator.comparing(Shelf::getRelevancyScore)).toList();
				else
					shelves = shelves.stream()
							.sorted(Comparator.comparing(Shelf::getRelevancyScore, Comparator.reverseOrder())).toList();
			}
			if (sortBy.get().equalsIgnoreCase("BRAND")) {
				if (sortType.isEmpty() || sortType.get().equalsIgnoreCase("ASC"))
					shelves = shelves.stream()
							.sorted((sh1, sh2) -> sh1.getProduct().getBrand().compareTo(sh2.getProduct().getBrand()))
							.toList();
				else
					shelves = shelves.stream()
							.sorted((sh1, sh2) -> sh2.getProduct().getBrand().compareTo(sh1.getProduct().getBrand()))
							.toList();
			}
			if (sortBy.get().equalsIgnoreCase("CATEGORY")) {
				if (sortType.isEmpty() || sortType.get().equalsIgnoreCase("ASC"))
					shelves = shelves.stream().sorted(
							(sh1, sh2) -> sh1.getProduct().getCategory().compareTo(sh2.getProduct().getCategory()))
							.toList();
				else
					shelves = shelves.stream().sorted(
							(sh1, sh2) -> sh2.getProduct().getCategory().compareTo(sh1.getProduct().getCategory()))
							.toList();
			}
		}
		if (page.isPresent() && pageSize.isPresent()) {
			shelves = shelves.stream().skip((page.get() - 1) * pageSize.get()).limit(pageSize.get()).toList();
		}
		return shelves.stream().map(Shelf::getProduct).map(ModelMapper::getProductDto).toList();
	}
}
