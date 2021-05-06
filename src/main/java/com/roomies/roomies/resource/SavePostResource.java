package com.roomies.roomies.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SavePostResource {

    @NotNull
    private String title;

    @NotNull
    @Lob
    private String address;

    @NotNull
    private String district;

    @NotNull
    private String department;

    @NotNull
    private float price;

    @NotNull
    private int roomQuantity;

    @NotNull
    private int bathQuantity;
}
