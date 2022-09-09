package com.example.renACar.requests.rentalsRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

//	@NotNull
//	@Min(1)
//	private int carCarId;
	
	@NotNull
	private LocalDate rentDate;

	@Nullable
	private LocalDate returnDate;

	@NotNull
	@Min(1)
	private int rentCityId;

	@NotNull
	@Min(1)
	private int deliveredCityId;

	@Min(0)
	private double returnKilometer;

	@NotNull
	@Min(1)
	private int customerId;

}