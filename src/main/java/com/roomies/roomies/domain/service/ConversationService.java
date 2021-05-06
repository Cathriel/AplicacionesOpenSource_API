package com.roomies.roomies.domain.service;

import com.roomies.roomies.domain.model.Conversation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ConversationService {
    Page<Conversation> getAllConversationsByUserId(Long userId,Pageable pageable);
    Conversation getConversationById(Long conversationId);
    Conversation createConversation(Conversation conversation);
    ResponseEntity<?> deleteConversation(Long conversationId);

}
