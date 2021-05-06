package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;

import java.util.Date;

public class PaymentMethodResource extends AuditModel {
    private Long id;
    private Long cardNumber;
    private String cvv;
    private Date expiryDate;
}
