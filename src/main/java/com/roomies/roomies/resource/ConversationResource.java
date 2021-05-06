package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;
import com.roomies.roomies.domain.model.User;

public class ConversationResource extends AuditModel {
    private Long id;
    private UserResource sender;
    private UserResource receiver;

    public Long getId() {
        return id;
    }

    public ConversationResource setId(Long id) {
        this.id = id;
        return this;
    }

    public UserResource getSender() {
        return sender;
    }

    public ConversationResource setSender(UserResource sender) {
        this.sender = sender;
        return this;
    }

    public UserResource getReceiver() {
        return receiver;
    }

    public ConversationResource setReceiver(UserResource receiver) {
        this.receiver = receiver;
        return this;
    }
}