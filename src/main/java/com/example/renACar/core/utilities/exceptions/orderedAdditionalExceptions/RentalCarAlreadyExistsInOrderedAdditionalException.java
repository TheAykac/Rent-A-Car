package com.example.renACar.core.utilities.exceptions.orderedAdditionalExceptions;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class RentalCarAlreadyExistsInOrderedAdditionalException extends BusinessException {

    public RentalCarAlreadyExistsInOrderedAdditionalException(String message) {
        super(message);
    }
}
