package com.ananyo.razorpay.merchant.service.impl;

import com.ananyo.razorpay.common.enums.MerchantStatus;
import com.ananyo.razorpay.common.enums.UserRole;
import com.ananyo.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.ananyo.razorpay.merchant.dto.response.MerchantResponse;
import com.ananyo.razorpay.merchant.entity.AppUser;
import com.ananyo.razorpay.merchant.entity.Merchant;
import com.ananyo.razorpay.merchant.repository.AppUserRepository;
import com.ananyo.razorpay.merchant.repository.MerchantRepository;
import com.ananyo.razorpay.merchant.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;

    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {
        if (merchantRepository.existsByEmail(request.email())){
            throw new RuntimeException("Merchant with email already exists: " + request.email());
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();

        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password())//TODO: encrypt using bCrypt
                .role(UserRole.OWNER)
                .build();

        appUserRepository.save(appUser);

        return new MerchantResponse(merchant.getId(), merchant.getName(),
                merchant.getEmail(), merchant.getBusinessName(),
                merchant.getBusinessType(), merchant.getStatus());
    }
}
