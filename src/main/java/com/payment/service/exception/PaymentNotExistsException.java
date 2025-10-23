package com.payment.service.exception;

public class PaymentNotExistsException extends RuntimeException {

    public PaymentNotExistsException() {
    }

    public PaymentNotExistsException(String message) {
        super(message);
    }
}
