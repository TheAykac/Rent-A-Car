package com.example.renACar.core.utilities.exceptions.orderedAdditionalExceptions;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class AdditionalQuantityNotValidException extends BusinessException {

    public AdditionalQuantityNotValidException(String message) {
        super(message);
    }
}
