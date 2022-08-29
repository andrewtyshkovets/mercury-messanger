package com.bomgee.nemyti.chats;

import com.bomgee.nemyti.chats.model.ChatDto;
import com.bomgee.nemyti.chats.service.ChatsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(value = "*")
public class ChatsController {
    private final ChatsService chatsService;

    public ChatsController(ChatsService chatsService) {
        this.chatsService = chatsService;
    }

    @GetMapping("/chats")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ChatDto> getChats() {
        log.info("get all chats");
        return chatsService.getAllChats();
    }

    @GetMapping("/chats/{chatId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ChatDto getChatById(@PathVariable Long chatId) {
        log.info("get all chats");
        return chatsService.getChatDtoById(chatId);
    }

    @PostMapping("/chats")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ChatDto createChat(@RequestBody ChatDto chatDto) {
        log.info("create chat");
       return chatsService.createChat(chatDto);
    }
}


