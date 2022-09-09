package com.example.renACar.core.utilities.exceptions.cityExceptions;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class CityAlreadyExistsException extends BusinessException {

	public CityAlreadyExistsException(String message) {
        super(message);
    }
}
