package com.payment.service.entity;

import com.payment.service.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "payments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "currency")
    private String currency; // e.g., "INR", "USD"

    @Column(name = "paymentMethod")
    private String paymentMethod; // e.g., "CARD", "UPI", "NET BANKING"

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Status status;

}
