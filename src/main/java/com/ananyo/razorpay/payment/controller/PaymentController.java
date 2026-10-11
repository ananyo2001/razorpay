package com.ananyo.razorpay.payment.controller;

import com.ananyo.razorpay.payment.dto.response.PaymentResponse;
import com.ananyo.razorpay.payment.dto.request.PaymentInitRequest;
import com.ananyo.razorpay.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
@Tag(name = "💳Payment Services", description = "Used for initiating payments")
public class PaymentController {

    private final PaymentService paymentService;
    UUID merchantId = UUID.fromString("053e0303-1e6c-4457-9028-d4bcbb35d783");

    @PostMapping
    public ResponseEntity<PaymentResponse> initiate(@Valid @RequestBody PaymentInitRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.initiate(merchantId,request));
    }

    @PostMapping("{paymentId}/capture")
    public ResponseEntity<PaymentResponse> capture(@PathVariable UUID paymentId){
        return ResponseEntity.ok(paymentService.capture(merchantId,paymentId));
    }
}
