package com.bomgee.nemyti.chats.service;

import com.bomgee.nemyti.chats.model.Chat;
import com.bomgee.nemyti.chats.model.ChatDto;
import com.bomgee.nemyti.chats.repository.ChatsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatsService {
    private final ChatsRepository chatsRepository;
    private final ChatsMapper chatsMapper;

    public ChatsService(ChatsRepository chatsRepository, ChatsMapper chatsMapper) {
        this.chatsRepository = chatsRepository;
        this.chatsMapper = chatsMapper;
    }

    public List<ChatDto> getAllChats() {
        return chatsRepository.findAll().stream().map(chatsMapper::chatToChatDto).collect(Collectors.toList());
    }

    public ChatDto createChat(ChatDto chatDto) {
        return chatsMapper.chatToChatDto(chatsRepository.save(chatsMapper.chatDtoToChat(chatDto)));
    }

    public Chat getChatById(Long chatId) {
        return chatsRepository.findById(chatId).orElseThrow(() -> new RuntimeException());
    }

    public ChatDto getChatDtoById(Long chatId) {
        return chatsMapper.chatToChatDto(this.getChatById(chatId));
    }
}
