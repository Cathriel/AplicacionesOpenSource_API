package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Conversation;
import com.roomies.roomies.domain.repository.ConversationRepository;
import com.roomies.roomies.domain.service.ConversationService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Override
    public Page<Conversation> getAllConversationsByProfileId(Long profileSenderId,Pageable pageable) {
        return conversationRepository.findBySenderId(profileSenderId,pageable);
    }

    @Override
    public Conversation getConversationById(Long conversationId) {
        return conversationRepository.findById(conversationId)
                .orElseThrow(()->new ResourceNotFoundException("Conversation","Id",conversationId));
    }

    @Override
    public Conversation createConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Override
    public ResponseEntity<?> deleteConversation(Long conversationId) {
        Conversation conversation= conversationRepository.findById(conversationId)
                .orElseThrow(()->new ResourceNotFoundException("Conversation","Id",conversationId));
        conversationRepository.delete(conversation);
        return ResponseEntity.ok().build();
    }
}
