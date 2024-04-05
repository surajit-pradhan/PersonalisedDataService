package com.assignment.PersonalisedDataService.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.PersonalisedDataService.model.ProductDto;
import com.assignment.PersonalisedDataService.model.ShopperDto;
import com.assignment.PersonalisedDataService.services.ProductService;
import com.assignment.PersonalisedDataService.services.ShopperService;

@RestController
@RequestMapping("/internal")
public class InternalController {

	@Autowired
	ProductService productService;

	@Autowired
	ShopperService shopperService;

	@PostMapping("/importProducts")
	private ResponseEntity<String> importProducts(@RequestBody Set<ProductDto> products) {
		productService.importProducts(products);
		return ResponseEntity.ok("SUCCESS");
	}

	@PostMapping("/importShoppers")
	private ResponseEntity<String> importShoppers(@RequestBody Set<ShopperDto> shoppers) {
		shopperService.importShoppers(shoppers);
		return ResponseEntity.ok("SUCCESS");
	}

}
