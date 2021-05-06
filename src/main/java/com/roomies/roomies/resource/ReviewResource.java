package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;

public class ReviewResource extends AuditModel {

    private Long id;
    private String content;
    private int starQuantity;
    private PostResource post;
    private UserResource user;
}
