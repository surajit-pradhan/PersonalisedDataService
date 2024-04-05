package com.assignment.PersonalisedDataService.util;

import java.util.Set;
import java.util.stream.Collectors;

import com.assignment.PersonalisedDataService.entity.Product;
import com.assignment.PersonalisedDataService.entity.Shelf;
import com.assignment.PersonalisedDataService.entity.ShelfKey;
import com.assignment.PersonalisedDataService.entity.Shopper;
import com.assignment.PersonalisedDataService.model.ProductDto;
import com.assignment.PersonalisedDataService.model.ShelfDto;
import com.assignment.PersonalisedDataService.model.ShopperDto;

public class ModelMapper {

	public static Product getProductEnity(ProductDto productDto) {
		return Product.builder().id(productDto.getProductId()).brand(productDto.getBrand())
				.category(productDto.getCategory()).build();
	}
	
	public static ProductDto getProductDto(Product product) {
		return ProductDto.builder().productId(product.getId()).brand(product.getBrand()).category(product.getCategory()).build();
	}

	public static Shopper getShopperEntity(ShopperDto shopperDto) {
		return Shopper.builder().id(shopperDto.getShopperId()).build();
	}

	public static Shelf getShelfEntity(ShelfDto shelfDto, String shopperId) {
		return Shelf.builder().id(ShelfKey.builder().productId(shelfDto.getProductId()).shopperId(shopperId).build())
				.relevancyScore(shelfDto.getRelevancyScore())
				.product(Product.builder().id(shelfDto.getProductId()).build())
				.shopper(Shopper.builder().id(shopperId).build()).build();
	}

	public static Set<Shelf> getShelfEntities(ShopperDto shopperDto) {
		return shopperDto.getShelf().stream().map(s -> ModelMapper.getShelfEntity(s, shopperDto.getShopperId()))
				.collect(Collectors.toSet());
	}

	public static ShelfDto getShelfDto(Shelf shelf) {
		return ShelfDto.builder().productId(shelf.getId().getProductId()).relevancyScore(shelf.getRelevancyScore())
				.build();
	}
}
