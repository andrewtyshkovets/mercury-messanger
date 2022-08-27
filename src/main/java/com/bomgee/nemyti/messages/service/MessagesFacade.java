package com.bomgee.nemyti.messages.service;

import com.bomgee.nemyti.chats.service.ChatsService;
import com.bomgee.nemyti.messages.model.Message;
import com.bomgee.nemyti.messages.model.MessageDto;
import org.springframework.stereotype.Service;

@Service
public class MessagesFacade {
    private final MessagesService messagesService;
    private final ChatsService chatsService;
    private final MessagesMapper messagesMapper;

    public MessagesFacade(MessagesService messagesService, ChatsService chatsService, MessagesMapper messagesMapper) {
        this.messagesService = messagesService;
        this.chatsService = chatsService;
        this.messagesMapper = messagesMapper;
    }

    public void createMessage(Long chatId, MessageDto messageDto) {
        Message message = messagesMapper.MessageDtoToMessage(messageDto);
        message.setChat(chatsService.getChatById(chatId));
        messagesService.createMessage(message);
    }
}
