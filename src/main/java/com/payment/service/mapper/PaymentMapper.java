package com.payment.service.mapper;

import com.payment.service.entity.PaymentModel;
import com.payment.service.enums.Status;
import com.payment.service.request.PaymentRequest;
import com.payment.service.response.PaymentResponse;

public class PaymentMapper {

    public static PaymentModel toEntity(PaymentRequest request) {
        return PaymentModel.builder()
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .paymentMethod(request.getPaymentMethod())
                .customerName(request.getCustomerName())
                .description(request.getDescription())
                .status(Status.PENDING)
                .build();
    }

    public static PaymentResponse toResponse(PaymentModel model){
        return PaymentResponse.builder()
                .id(model.getId())
                .transactionId(model.getTransactionId())
                .amount(model.getAmount())
                .currency(model.getCurrency())
                .paymentMethod(model.getPaymentMethod())
                .customerName(model.getCustomerName())
                .description(model.getDescription())
                .status(model.getStatus())
                .build();
    }
}
