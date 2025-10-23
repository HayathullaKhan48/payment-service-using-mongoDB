package com.payment.service.service.impl;

import com.payment.service.entity.PaymentModel;
import com.payment.service.enums.Status;
import com.payment.service.exception.PaymentAlreadyExistsException;
import com.payment.service.exception.PaymentNotExistsException;
import com.payment.service.mapper.PaymentMapper;
import com.payment.service.repository.PaymentRepository;
import com.payment.service.request.PaymentRequest;
import com.payment.service.response.PaymentResponse;
import com.payment.service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponse create(PaymentRequest request) {
        Optional<PaymentModel> existing = paymentRepository.findByTransactionId(request.getCustomerName());
        if (existing.isPresent()) {
            throw new PaymentAlreadyExistsException("Payment already exists for customer: " + request.getCustomerName());
        }

        PaymentModel payment = PaymentMapper.toEntity(request);
        payment.setStatus(Status.PENDING); // initial status
        PaymentModel savedPayment = paymentRepository.save(payment);
        return PaymentMapper.toResponse(savedPayment);
    }

    @Override
    public List<PaymentResponse> getPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse getById(String id) {
        PaymentModel payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotExistsException("Payment not found with ID: " + id));
        return PaymentMapper.toResponse(payment);
    }

    @Override
    public List<PaymentResponse> searchByCustomerName(String customerName) {
        List<PaymentModel> payments = paymentRepository.findByCustomerNameContainingIgnoreCase(customerName);
        if (payments.isEmpty()) {
            throw new PaymentNotExistsException("No payments found for customer: " + customerName);
        }
        return payments.stream()
                .map(PaymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponse update(String id, PaymentRequest request) {
        PaymentModel existing = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotExistsException("Cannot update — Payment not found with ID: " + id));

        existing.setCustomerName(request.getCustomerName());
        existing.setAmount(request.getAmount());
        existing.setCurrency(request.getCurrency());
        existing.setPaymentMethod(request.getPaymentMethod());
        existing.setDescription(request.getDescription());

        PaymentModel updated = paymentRepository.save(existing);
        return PaymentMapper.toResponse(updated);
    }

    @Override
    public PaymentResponse statusUpdate(String id, Status status) {
        PaymentModel existing = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotExistsException("Payment not found with ID: " + id));

        existing.setStatus(status);
        PaymentModel updated = paymentRepository.save(existing);
        return PaymentMapper.toResponse(updated);
    }

    @Override
    public PaymentResponse Delete(String id) {
        PaymentModel existing = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotExistsException("Cannot delete — Payment not found with ID: " + id));

        existing.setStatus(Status.INACTIVE);
        PaymentModel updated = paymentRepository.save(existing);
        return PaymentMapper.toResponse(updated);
    }
}
