package com.payment.service.entity;

import com.payment.service.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

    @Id
    private String id;
    private Long transactionId;
    private Long amount;
    private String currency;
    private String paymentMethod;
    private String customerName;
    private String description;
    private Status status;
}
