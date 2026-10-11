package com.ananyo.razorpay.vault.controller;

import com.ananyo.razorpay.vault.dto.request.TokenizeRequest;
import com.ananyo.razorpay.vault.dto.response.TokenizeResponse;
import com.ananyo.razorpay.vault.service.VaultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/vault")
@RequiredArgsConstructor
public class VaultController {

    private final VaultService vaultService;
    UUID merchantId = UUID.fromString("8bcf5f0c-b38e-4e78-99cf-383100467ad5");

    @PostMapping("/tokenize")
    public ResponseEntity<TokenizeResponse> tokenize(@RequestBody @Valid TokenizeRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vaultService.tokenize(request, merchantId));

    }
}
