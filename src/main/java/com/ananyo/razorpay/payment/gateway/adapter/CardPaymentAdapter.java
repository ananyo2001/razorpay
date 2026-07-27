package com.ananyo.razorpay.payment.gateway.adapter;

import com.ananyo.razorpay.payment.gateway.PaymentAdapter;
import com.ananyo.razorpay.payment.gateway.dto.PaymentRequest;
import com.ananyo.razorpay.payment.gateway.dto.PaymentResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CardPaymentAdapter implements PaymentAdapter {
    @Override
    public PaymentResult initiate(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResult capture(UUID paymentId) {
        return null;
    }
}
