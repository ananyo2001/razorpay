package com.ananyo.razorpay.vault.service;

import com.ananyo.razorpay.common.entity.Money;
import com.ananyo.razorpay.payment.processor.dto.PaymentProcessorResponse;
import com.ananyo.razorpay.vault.dto.request.TokenizeRequest;
import com.ananyo.razorpay.vault.dto.response.TokenizeResponse;
import jakarta.validation.Valid;

import java.util.Map;
import java.util.UUID;

public interface VaultService {
    TokenizeResponse tokenize(@Valid TokenizeRequest request, UUID merchantId);

    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
