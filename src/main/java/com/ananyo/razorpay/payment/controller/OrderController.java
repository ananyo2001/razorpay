package com.ananyo.razorpay.payment.controller;

import com.ananyo.razorpay.payment.dto.request.CreateOrderRequest;
import com.ananyo.razorpay.payment.dto.response.OrderResponse;
import com.ananyo.razorpay.payment.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
@Tag(name = "📦Order Services", description = "Used for order related services")
public class OrderController {

    private final OrderService orderService;

    UUID merchantId = UUID.fromString("053e0303-1e6c-4457-9028-d4bcbb35d783"); //TODO: replace it with merchant context

    @PostMapping
    @Operation(summary = "Create an order for merchant")
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid CreateOrderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(merchantId,request));
    }
}
