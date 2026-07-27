package com.ananyo.razorpay.payment.statemachine;

import com.ananyo.razorpay.common.enums.PaymentActor;
import com.ananyo.razorpay.common.enums.PaymentEvent;
import com.ananyo.razorpay.common.enums.PaymentStatus;
import com.ananyo.razorpay.payment.entity.Payment;
import com.ananyo.razorpay.payment.entity.PaymentTransitionLog;
import com.ananyo.razorpay.payment.repository.PaymentTransitionLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentTransitionService {
    private final PaymentTransitionLogRepository paymentTransitionLogRepository;
    private final PaymentStateMachine paymentStateMachine;

    public PaymentStatus apply(Payment payment, PaymentEvent event){
        PaymentStatus next = paymentStateMachine.transition(payment.getStatus(), event);

        PaymentTransitionLog log = PaymentTransitionLog.builder()
                .payment(payment)
                .fromStatus(payment.getStatus())
                .event(event)
                .toStatus(next)
                .actor(PaymentActor.SYSTEM)
                .occurredAt(LocalDateTime.now())
                .build();

        payment.setStatus(next);
        paymentTransitionLogRepository.save(log);

        return next;
    }
}
