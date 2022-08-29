package com.bomgee.nemyti.chats.repository;

import com.bomgee.nemyti.chats.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatsRepository extends JpaRepository<Chat, Long> {
    @Query(nativeQuery = true, value = "select * from chats where user1_id = :userId or user2_id = :userId")
    List<Chat> findAllBySenderOrReceiver(@Param("userId") Long userId);
}
