package com.example.renACar.requests.carRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
	
	@NotNull
	@Min(1)
	private double dailyPrice;
	
	@NotNull
	@Min(2010)
	private int modelYear;
	
	@NotNull
	private String description;
	
	@NotNull
	@Min(0)
	private int kilometer;
	
	@NotNull
	@Min(1)
	private int brandId;
	
	@NotNull
	@Min(1)
	private int colorId;

}
