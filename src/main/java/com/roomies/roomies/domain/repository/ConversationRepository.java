package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation,Long> {
}
