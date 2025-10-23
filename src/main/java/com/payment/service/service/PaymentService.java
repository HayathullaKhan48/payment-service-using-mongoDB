package com.payment.service.service;

import com.payment.service.enums.Status;
import com.payment.service.request.PaymentRequest;
import com.payment.service.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse create(PaymentRequest request);
    List<PaymentResponse> getPayments();
    PaymentResponse getById(String id);
    List<PaymentResponse> searchByCustomerName(String customerName);
    PaymentResponse update(String id, PaymentRequest request);
    PaymentResponse statusUpdate(String id, Status status);
    PaymentResponse softDelete(String id);
}
