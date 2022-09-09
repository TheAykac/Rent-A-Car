package com.example.renACar.core.utilities.exceptions.orderedAdditionalExceptions;

import com.example.renACar.core.utilities.exceptions.BusinessException;

public class OrderedAdditionalAlreadyExistsException extends BusinessException {

    public OrderedAdditionalAlreadyExistsException(String message) {
        super(message);
    }
}
