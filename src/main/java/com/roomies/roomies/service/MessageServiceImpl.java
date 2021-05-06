package com.roomies.roomies.service;

import com.roomies.roomies.domain.model.Message;
import com.roomies.roomies.domain.repository.MessageRepository;
import com.roomies.roomies.domain.service.MessageService;
import com.roomies.roomies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Page<Message> getAllMessages(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(()->new ResourceNotFoundException("Message","Id",messageId));
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Long messageId, Message messageRequest) {
        Message message =messageRepository.findById(messageId)
                .orElseThrow(()->new ResourceNotFoundException("Message","Id",messageId));
        message.setContent(messageRequest.getContent());
        return messageRepository.save(message);
    }

    @Override
    public ResponseEntity<?> deleteMessage(Long messageId) {
        Message message =messageRepository.findById(messageId)
                .orElseThrow(()->new ResourceNotFoundException("Message","Id",messageId));
        messageRepository.delete(message);
        return ResponseEntity.ok().build();
    }
}
