package com.ananyo.razorpay.merchant.controller;

import com.ananyo.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.ananyo.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.ananyo.razorpay.merchant.dto.response.ApiKeyResponse;
import com.ananyo.razorpay.merchant.security.MerchantContext;
import com.ananyo.razorpay.merchant.service.ApiKeyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/api-keys")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
@Tag(name = "🗝️ApiKey Services", description = "Used for API key related services")
public class ApiKeyController {
    private final ApiKeyService apiKeyService;
    private final MerchantContext merchantContext;

    @PostMapping
    @Operation(summary = "Create Api Key")
    public ResponseEntity<ApiKeyCreateResponse> create(
            @RequestBody @Valid CreateApiKeyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiKeyService.create(merchantContext.getMerchantId(), request));
    }

    @GetMapping
    @Operation(summary = "Get Api Keys of a Merchant")
    public ResponseEntity<List<ApiKeyResponse>> listByMerchant(){
        return ResponseEntity.ok(apiKeyService.listByMerchant(merchantContext.getMerchantId()));
    }

    @DeleteMapping("/{keyId}")
    @Operation(summary = "Disable an APi Key")
    public ResponseEntity<Void> revoke(@PathVariable UUID keyId){
        apiKeyService.revoke(merchantContext.getMerchantId(),keyId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{keyId}/rotate")
    @Operation(summary = "Generate new secret for an Api Key")
    public ResponseEntity<ApiKeyCreateResponse> rotate(@PathVariable UUID keyId){
        return ResponseEntity.ok(apiKeyService.rotate(merchantContext.getMerchantId(), keyId));
    }
}
