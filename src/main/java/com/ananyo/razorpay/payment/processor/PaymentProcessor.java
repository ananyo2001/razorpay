package com.ananyo.razorpay.payment.processor;

import com.ananyo.razorpay.payment.processor.dto.PaymentProcessorRequest;
import com.ananyo.razorpay.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);

}
