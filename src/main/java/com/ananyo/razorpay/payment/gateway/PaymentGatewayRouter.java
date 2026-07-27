package com.ananyo.razorpay.payment.gateway;

import com.ananyo.razorpay.common.enums.PaymentMethod;
import com.ananyo.razorpay.payment.config.PaymentAdapterConfig;
import com.ananyo.razorpay.payment.gateway.dto.PaymentRequest;
import com.ananyo.razorpay.payment.gateway.dto.PaymentResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentGatewayRouter {

    private final Map<PaymentMethod, PaymentAdapter> paymentAdapters;

    public PaymentResult initiate(PaymentRequest request) {
        PaymentAdapter adapter = paymentAdapters.get(request.method());
        if (adapter == null)
            throw new IllegalArgumentException("No payment adapter registered for method: " + request.method().name());

        return adapter.initiate(request);
    }

    public PaymentResult capture(PaymentMethod method, UUID paymentId) {
        PaymentAdapter adapter = paymentAdapters.get(method);
        if (adapter == null)
            throw new IllegalArgumentException("No payment adapter registered for method: " + method);

        return adapter.capture(paymentId);
    }
}
