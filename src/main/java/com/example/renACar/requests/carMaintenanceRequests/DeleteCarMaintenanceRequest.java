package com.example.renACar.requests.carMaintenanceRequests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteCarMaintenanceRequest {
	
	@NotBlank
	@NotNull
	private int id;

}
