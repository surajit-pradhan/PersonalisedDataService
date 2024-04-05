package com.assignment.PersonalisedDataService.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shelves",indexes = { @Index(name = "idx_shoppers_products", columnList = "shopper_id,product_id") })
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shelf implements Serializable {

	private static final long serialVersionUID = 5258522381002255079L;

	@EmbeddedId
	private ShelfKey id;

	@ManyToOne
	@MapsId("shopperId")
	@JoinColumn(name = "shopper_id")
	private Shopper shopper;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;

	@Column
	private double relevancyScore;

}