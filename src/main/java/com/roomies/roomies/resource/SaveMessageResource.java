package com.roomies.roomies.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class SaveMessageResource {

    @NotNull
    @Lob
    private String content;
}
