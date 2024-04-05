package com.assignment.PersonalisedDataService.model;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopperDto implements Serializable {
	private static final long serialVersionUID = 6175990000566181942L;
	private String shopperId;
	private Set<ShelfDto> shelf;
}
