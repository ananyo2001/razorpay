package com.ananyo.razorpay.payment.service;

import com.ananyo.razorpay.payment.dto.request.PaymentInitRequest;
import com.ananyo.razorpay.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {
    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);

    PaymentResponse capture(UUID merchantId, UUID paymentId);
}
