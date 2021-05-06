package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class PostResource extends AuditModel {
    private Long id;
    private String title;
    private String address;
    private String district;
    private String department;
    private float price;
    private int roomQuantity;
    private int bathQuantity;
}
