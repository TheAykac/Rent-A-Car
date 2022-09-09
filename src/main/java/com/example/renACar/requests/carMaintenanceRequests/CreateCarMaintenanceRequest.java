package com.example.renACar.requests.carMaintenanceRequests;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {
	
	@NotNull
	@NotBlank
	private String description;
	
	@NotNull
	private LocalDate returnDate;
	
	
	@NotNull
    @Min(1)
	private int carId;

}
