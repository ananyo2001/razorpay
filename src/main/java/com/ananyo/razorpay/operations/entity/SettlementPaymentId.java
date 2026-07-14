package com.ananyo.razorpay.operations.entity;

import com.ananyo.razorpay.common.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CompositeType;

import java.util.UUID;

@Embeddable
@Getter
@Setter
public class SettlementPaymentId extends BaseEntity {
    private UUID settlementId;
    private UUID paymentId;
}
