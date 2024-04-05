package com.assignment.PersonalisedDataService.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	private static final long serialVersionUID = -1673688017701627917L;

	@Id
	private String id;

	@OneToMany(mappedBy = "product")
	private Set<Shelf> shelves;

	@Column
	private String category;

	@Column
	private String brand;

}
