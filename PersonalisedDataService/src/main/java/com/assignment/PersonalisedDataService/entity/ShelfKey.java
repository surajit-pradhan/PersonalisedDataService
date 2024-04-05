package com.assignment.PersonalisedDataService.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShelfKey implements Serializable {

	private static final long serialVersionUID = -6573128549777063184L;

	@Column(name = "shopper_id")
	private String shopperId;

	@Column(name = "product_id")
	private String productId;

}
