package com.payment.service.response;

import com.payment.service.enums.Status;
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
public class PaymentResponse {
    private String id;
    private Long transactionId;
    private Long amount;
    private String currency;
    private String paymentMethod;
    private String customerName;
    private String description;
    private Status status;
}
