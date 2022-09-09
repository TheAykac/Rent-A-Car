package com.example.renACar.core.utilities.exceptions.cityExceptions;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class CityNotFoundException extends BusinessException{

	public CityNotFoundException(String message) {
        super(message);
    }
}
