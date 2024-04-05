package com.assignment.PersonalisedDataService.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assignment.PersonalisedDataService.entity.Product;
import com.assignment.PersonalisedDataService.model.ProductDto;
import com.assignment.PersonalisedDataService.repositories.ProductRepository;
import com.assignment.PersonalisedDataService.util.ModelMapper;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void importProducts(Set<ProductDto> products) {
		Set<Product> productEntities = products.stream().map(p->ModelMapper.getProductEnity(p))
				.collect(Collectors.toSet());
		productRepository.saveAll(productEntities);
	}

	@Cacheable(key = "#productId", value = "'product'")
	public ProductDto getProductById(String productId) {
		Product product = productRepository.findById(productId).get();
		return ProductDto.builder().productId(product.getId()).brand(product.getBrand()).category(product.getCategory())
				.build();
	}
}
