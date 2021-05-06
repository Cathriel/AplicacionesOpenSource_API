package com.roomies.roomies.resource;

import com.roomies.roomies.domain.model.AuditModel;
import com.roomies.roomies.resource.ConversationResource;
import com.roomies.roomies.resource.UserResource;

public class MessageResource extends AuditModel {
    private Long id;
    private String content;
    private UserResource sender;
    private ConversationResource landlordConversation;
    private ConversationResource leaseholderConversation;
}
