package com.assignment.PersonalisedDataService.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShelfDto implements Serializable {
	private static final long serialVersionUID = 1195140150500471864L;
	private String productId;
	private Double relevancyScore;
}
