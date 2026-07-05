package com.ananyo.razorpay.merchant.dto.request;

import com.ananyo.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
