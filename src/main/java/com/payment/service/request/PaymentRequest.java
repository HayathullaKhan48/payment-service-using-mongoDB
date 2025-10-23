package com.payment.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    private Long amount;
    private String currency;
    private String paymentMethod;
    private String customerName;
    private String description;
}
