package com.roomies.roomies.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="payment_methods")
public class PaymentMethod extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "user_payment_methods",
    joinColumns = {@JoinColumn(name = "payment_method_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> userPaymentMethods;

    @NotNull
    private String cvv;

    @NotNull
    private Date expiryDate;

    public PaymentMethod() {
    }

    public Long getId() {
        return id;
    }

    public PaymentMethod setId(Long id) {
        this.id = id;
        return this;
    }

    public List<User> getUserPaymentMethods() {
        return userPaymentMethods;
    }

    public PaymentMethod setUserPaymentMethods(List<User> userPaymentMethods) {
        this.userPaymentMethods = userPaymentMethods;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public PaymentMethod setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public PaymentMethod setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }
}
