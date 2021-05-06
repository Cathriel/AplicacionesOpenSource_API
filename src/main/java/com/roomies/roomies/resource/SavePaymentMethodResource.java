package com.roomies.roomies.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SavePaymentMethodResource {

    @NotNull
    private Long cardNumber;
    @NotNull
    private String cvv;

    @NotNull
    private Date expiryDate;
}
