package com.assignment.PersonalisedDataService.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shoppers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shopper implements Serializable {

	private static final long serialVersionUID = -8176526341578593828L;

	@Id
	String id;

	@OneToMany(mappedBy = "shopper")
	Set<Shelf> shelves;

}