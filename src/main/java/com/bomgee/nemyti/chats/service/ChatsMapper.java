package com.bomgee.nemyti.chats.service;

import com.bomgee.nemyti.chats.model.Chat;
import com.bomgee.nemyti.chats.model.ChatDto;
import com.bomgee.nemyti.messages.service.MessagesMapper;
import com.bomgee.nemyti.users.service.UsersMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UsersMapper.class, MessagesMapper.class})
public interface ChatsMapper {

    ChatDto chatToChatDto(Chat chat);

    Chat chatDtoToChat(ChatDto chatDto);
}
