package com.ananyo.razorpay.payment.gateway;

import com.ananyo.razorpay.payment.gateway.dto.PaymentRequest;
import com.ananyo.razorpay.payment.gateway.dto.PaymentResult;

import java.util.UUID;

public interface PaymentAdapter {
    PaymentResult initiate(PaymentRequest request);

    PaymentResult capture(UUID paymentId);
}
