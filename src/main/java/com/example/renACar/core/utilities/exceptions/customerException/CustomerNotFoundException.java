package com.example.renACar.core.utilities.exceptions.customerException;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class CustomerNotFoundException extends BusinessException{

	 public CustomerNotFoundException (String message) {		 
		 super(message);
	 }
}
