package com.roomies.roomies.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="conversations")
public class Conversation extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long senderId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="profile_id",nullable = false)
    @JsonIgnore
    private Profile sender;


    public Conversation() {
    }

    public Long getId() {
        return id;
    }

    public Conversation setId(Long id) {
        this.id = id;
        return this;
    }

    public Profile getSender() {
        return sender;
    }

    public Conversation setSender(Profile sender) {
        this.sender = sender;
        return this;
    }
/*
    public User getReceiver() {
        return receiver;
    }

    public Conversation setReceiver(User receiver) {
        this.receiver = receiver;
        return this;
    }*/
}
