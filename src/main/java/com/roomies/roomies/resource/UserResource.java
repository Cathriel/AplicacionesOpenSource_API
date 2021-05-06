package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;

import java.util.Date;
import java.util.List;

public class UserResource extends AuditModel {
    protected Long id;
    protected String name;
    protected String lastName;
    protected Long cellphone;
    protected String idCard;
    protected String Description;
    protected Date birthday;
    protected String department;
    protected String province;
    protected String district;
    protected String address;
    protected String email;
    protected String password;
    protected List<PaymentMethodResource> userPaymentMethods;
    protected PlanResource plan;
}
