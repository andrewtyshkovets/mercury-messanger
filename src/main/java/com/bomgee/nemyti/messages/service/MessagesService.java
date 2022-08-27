package com.bomgee.nemyti.messages.service;

import com.bomgee.nemyti.messages.model.Message;
import com.bomgee.nemyti.messages.repository.MessagesRepository;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {
    private final MessagesRepository messagesRepository;
    private final MessagesMapper messagesMapper;

    public MessagesService(MessagesRepository messagesRepository, MessagesMapper messagesMapper) {
        this.messagesRepository = messagesRepository;
        this.messagesMapper = messagesMapper;
    }

    public Message createMessage(Message message) {
        return messagesRepository.save(message);
    }
}
