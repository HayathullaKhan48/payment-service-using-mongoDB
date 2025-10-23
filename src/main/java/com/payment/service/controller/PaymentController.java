package com.payment.service.controller;

import com.payment.service.enums.Status;
import com.payment.service.request.PaymentRequest;
import com.payment.service.response.PaymentResponse;
import com.payment.service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment/v1")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public PaymentResponse createPayment(@RequestBody PaymentRequest request) {
        return paymentService.create(request);
    }

    @GetMapping("/getAll")
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getPayments();
    }

    @GetMapping("/getById/{id}")
    public PaymentResponse getPaymentById(@PathVariable String id) {
        return paymentService.getById(id);
    }

    @GetMapping("/searchByCustomerName/{customerName}")
    public List<PaymentResponse> searchByCustomerName(@PathVariable String customerName) {
        return paymentService.searchByCustomerName(customerName);
    }

    @PutMapping("/update/{id}")
    public PaymentResponse updatePayment(@PathVariable String id, @RequestBody PaymentRequest request) {
        return paymentService.update(id, request);
    }

    @PatchMapping("/statusUpdate/{id}/{status}")
    public PaymentResponse updatePaymentStatus(@PathVariable String id, @PathVariable Status status) {
        return paymentService.statusUpdate(id, status);
    }

    @DeleteMapping("/delete/{id}")
    public PaymentResponse deletePayment(@PathVariable String id) {
        return paymentService.Delete(id);
    }
}
