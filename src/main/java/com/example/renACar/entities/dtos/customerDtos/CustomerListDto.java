package com.example.renACar.entities.dtos.customerDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDto {

	private int id;
	
	private int userId;
	
	private String customerName;
}
