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

    UUID merchantId = UUID.fromString("8bcf5f0c-b38e-4e78-99cf-383100467ad5"); //TODO: replace it with merchant context

    @PostMapping
    @Operation(summary = "Create an order for merchant")
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid CreateOrderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderService.create(merchantId,request));
    }
}
