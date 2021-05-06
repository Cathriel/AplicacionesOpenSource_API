package com.roomies.roomies.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roomies.roomies.domain.model.Post;
import com.roomies.roomies.domain.model.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class SaveReviewResource {
    @NotNull
    @Lob
    private String content;

    @NotNull
    private int starQuantity;

}
