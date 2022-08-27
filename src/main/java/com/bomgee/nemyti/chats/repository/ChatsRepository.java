package com.bomgee.nemyti.chats.repository;

import com.bomgee.nemyti.chats.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatsRepository extends JpaRepository<Chat, Long> {
}
