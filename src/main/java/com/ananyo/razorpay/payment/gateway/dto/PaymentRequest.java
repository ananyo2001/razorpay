package com.ananyo.razorpay.payment.gateway.dto;

import com.ananyo.razorpay.common.entity.Money;
import com.ananyo.razorpay.common.enums.PaymentMethod;
import lombok.Builder;

import java.util.Map;
import java.util.UUID;
public record PaymentRequest(
    UUID paymentId,
    UUID orderId,
    UUID merchantId,
    Money amount,
    PaymentMethod method,
    Map<String,Object> methodDetails
) {
}
