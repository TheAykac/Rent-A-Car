package com.example.renACar.core.utilities.exceptions.additionalException;


import com.example.renACar.core.utilities.exceptions.BusinessException;

public class AdditionalAlreadyExistsException extends BusinessException{

	public AdditionalAlreadyExistsException (String message) {
		super(message);
	}
}
