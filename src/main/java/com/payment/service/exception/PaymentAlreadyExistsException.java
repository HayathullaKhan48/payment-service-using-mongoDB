package com.payment.service.exception;

public class PaymentAlreadyExistsException extends RuntimeException {

    public PaymentAlreadyExistsException() {
    }

    public PaymentAlreadyExistsException(String message) {
        super(message);
    }
}
