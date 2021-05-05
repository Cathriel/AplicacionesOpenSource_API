package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Conversation;
import com.roomies.roomies.domain.repository.ConversationRepository;
import com.roomies.roomies.domain.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Page<Conversation> getAllConversations(Pageable pageable) {
        return null;
    }

    @Override
    public Conversation getConversationById(Long conversationId) {
        return null;
    }

    @Override
    public Conversation createConversation(Conversation conversation) {
        return null;
    }

    @Override
    public Conversation updateConversation(Long conversationId, Conversation conversationRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteConversation(Long conversationId) {
        return null;
    }
}
