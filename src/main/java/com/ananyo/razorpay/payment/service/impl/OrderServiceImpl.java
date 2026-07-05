package com.ananyo.razorpay.payment.service.impl;

import com.ananyo.razorpay.common.exception.DuplicateResourceException;
import com.ananyo.razorpay.payment.dto.request.CreateOrderRequest;
import com.ananyo.razorpay.payment.dto.response.OrderResponse;
import com.ananyo.razorpay.payment.entity.OrderRecord;
import com.ananyo.razorpay.payment.repository.OrderRepository;
import com.ananyo.razorpay.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Value("${payment.order.default-order-expiry-minutes:30}")
    private Integer defaultOrderExpiryMinutes;

    @Override
    public OrderResponse create(UUID merchantId, CreateOrderRequest request) {

        if (request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())) {
            throw new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE", "Order with receipt already exists: " + request.receipt());
        }

        OrderRecord orderRecord = OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())
                .merchantId(merchantId)
                .expiresAt(request.expiresAt() != null ? request.expiresAt():
                        LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                .build();

        orderRecord = orderRepository.save(orderRecord);

        //TODO: publish kafka event about order creation.

        return new OrderResponse(orderRecord.getId(),merchantId,orderRecord.getReceipt(),
                orderRecord.getAmount(),orderRecord.getOrderStatus(),
                orderRecord.getAttempts(),orderRecord.getNotes(),
                orderRecord.getExpiresAt(),null);
    }
}
