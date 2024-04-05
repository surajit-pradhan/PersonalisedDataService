package com.assignment.PersonalisedDataService.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.PersonalisedDataService.model.ProductDto;
import com.assignment.PersonalisedDataService.model.ShopperDto;
import com.assignment.PersonalisedDataService.services.ProductService;
import com.assignment.PersonalisedDataService.services.ShopperService;

@RestController
@RequestMapping("/external")
public class ExternalController {

	@Autowired
	ProductService productService;

	@Autowired
	ShopperService shopperService;

	@GetMapping("/getAllProductById/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") String id) {
		ProductDto product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/getShopperProducts/{id}")
	public ResponseEntity<?> getShopperProductsById(@PathVariable("id") String id) {
		ShopperDto shopper = shopperService.getShopperProducts(id);
		return ResponseEntity.ok(shopper);
	}

	@GetMapping("/getPersonalisedProducts")
	public ResponseEntity<?> getPersonalisedProducts(@RequestParam(name = "shopperId") Optional<String> shopperId,
			@RequestParam(name = "category") Optional<Set<String>> categories,
			@RequestParam(name = "brand") Optional<Set<String>> brands,
			@RequestParam(name = "priceRange") Optional<Set<Double>> priceRange,
			@RequestParam(name = "sortBy") Optional<String> sortBy,
			@RequestParam(name = "sortType") Optional<String> sortType,
			@RequestParam(name = "page") Optional<Integer> page,
			@RequestParam(name = "pageSize") Optional<Integer> pageSize) {
		if (shopperId.isEmpty())
			return ResponseEntity.badRequest().body("shopperId is mandatory.");
		List<ProductDto> products = shopperService.getPersonalisedProducts(shopperId, categories, brands, priceRange,
				sortBy, sortType, page, pageSize);
		return ResponseEntity.ok(products);
	}
}
