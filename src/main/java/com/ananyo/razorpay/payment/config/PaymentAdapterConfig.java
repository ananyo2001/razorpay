package com.ananyo.razorpay.payment.config;

import com.ananyo.razorpay.common.enums.PaymentMethod;
import com.ananyo.razorpay.payment.gateway.PaymentAdapter;
import com.ananyo.razorpay.payment.gateway.adapter.CardPaymentAdapter;
import com.ananyo.razorpay.payment.gateway.adapter.NetBankingAdapter;
import com.ananyo.razorpay.payment.gateway.adapter.UpiPaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PaymentAdapterConfig {

    private final NetBankingAdapter netBankingAdapter;
    private final CardPaymentAdapter cardPaymentAdapter;
    private final UpiPaymentAdapter upiPaymentAdapter;

    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap(){
        return Map.of(
                PaymentMethod.CARD, cardPaymentAdapter,
                PaymentMethod.NETBANKING, netBankingAdapter,
                PaymentMethod.UPI, upiPaymentAdapter
        );
    }
}
