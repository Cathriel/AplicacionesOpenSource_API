package com.roomies.roomies.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SavePlanResource {

    @NotNull
    private float price;

    @NotNull
    private String name;

    @NotNull
    @Lob
    private String description;
}
