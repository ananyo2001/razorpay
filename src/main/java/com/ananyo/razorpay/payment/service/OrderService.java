package com.ananyo.razorpay.payment.service;

import com.ananyo.razorpay.payment.dto.request.CreateOrderRequest;
import com.ananyo.razorpay.payment.dto.response.OrderResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
