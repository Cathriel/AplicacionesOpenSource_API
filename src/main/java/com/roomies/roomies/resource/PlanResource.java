package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

public class PlanResource extends AuditModel {
    private Long id;
    private float price;
    private String name;
    private String description;
}
