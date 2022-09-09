package com.example.renACar.requests.colorRequests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequest {
	
	@NotBlank
	@NotNull
	@Min(3)
	private String colorName;

}
