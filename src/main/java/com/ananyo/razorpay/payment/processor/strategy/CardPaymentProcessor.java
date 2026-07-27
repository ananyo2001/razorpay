package com.ananyo.razorpay.payment.processor.strategy;

import com.ananyo.razorpay.payment.processor.PaymentProcessor;
import com.ananyo.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.ananyo.razorpay.payment.processor.dto.PaymentProcessorResponse;

public class CardPaymentProcessor implements PaymentProcessor {

    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        return null;
    }
}
