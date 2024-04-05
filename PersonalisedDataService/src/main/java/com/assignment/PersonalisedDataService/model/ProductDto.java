package com.assignment.PersonalisedDataService.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3902883073057882152L;
	private String productId;
	private String category;
	private String brand;

}
