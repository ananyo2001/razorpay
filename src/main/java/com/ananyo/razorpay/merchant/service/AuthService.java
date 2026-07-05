package com.ananyo.razorpay.merchant.service;

import com.ananyo.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.ananyo.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;

public interface AuthService {
    MerchantResponse signup(@Valid MerchantSignupRequest request);
}
