package com.example.renACar.requests.customerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
	
	private int userId;
	
	private String customerName;

}
