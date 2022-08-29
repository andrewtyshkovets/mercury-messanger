package com.bomgee.nemyti.messages;

import com.bomgee.nemyti.messages.model.MessageDto;
import com.bomgee.nemyti.messages.service.MessagesFacade;
import com.bomgee.nemyti.messages.service.MessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(value = "*")
public class MessagesController {

    private final MessagesService messagesService;
    private final MessagesFacade messagesFacade;

    public MessagesController(MessagesService messagesService, MessagesFacade messagesFacade) {
        this.messagesService = messagesService;
        this.messagesFacade = messagesFacade;
    }

    @PostMapping("/chats/{chatId}/message")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void sendMessage(@PathVariable Long chatId, @RequestBody MessageDto messageDto) {
        log.info("send message from user with id = {}", messageDto.getSender().getId());
        messagesFacade.createMessage(chatId, messageDto);
    }
}
