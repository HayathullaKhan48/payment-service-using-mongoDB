package com.payment.service.repository;

import com.payment.service.entity.PaymentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentModel, String> {
    Optional<PaymentModel> findByTransactionId(String transactionId);
    List<PaymentModel> findByCustomerNameContainingIgnoreCase(String customerName);
}
