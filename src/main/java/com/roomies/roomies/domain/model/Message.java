package com.roomies.roomies.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="messages")
public class Message extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    @JsonIgnore
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "conversation_id",nullable = false)
    @JsonIgnore
    private Conversation landlordConversation;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "conversation_id",nullable = false)
    @JsonIgnore
    private Conversation leaseholderConversation;

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public User getSender() {
        return sender;
    }

    public Message setSender(User sender) {
        this.sender = sender;
        return this;
    }

    public Conversation getLandlordConversation() {
        return landlordConversation;
    }

    public Message setLandlordConversation(Conversation landlordConversation) {
        this.landlordConversation = landlordConversation;
        return this;
    }

    public Conversation getLeaseholderConversation() {
        return leaseholderConversation;
    }

    public Message setLeaseholderConversation(Conversation leaseholderConversation) {
        this.leaseholderConversation = leaseholderConversation;
        return this;
    }
}
