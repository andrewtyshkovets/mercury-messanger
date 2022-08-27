package com.bomgee.nemyti.messages.service;

import com.bomgee.nemyti.chats.service.ChatsMapper;
import com.bomgee.nemyti.messages.model.Message;
import com.bomgee.nemyti.messages.model.MessageDto;
import com.bomgee.nemyti.users.service.UsersMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UsersMapper.class, ChatsMapper.class})
public interface MessagesMapper {

    MessageDto MessageToMessageDto(Message message);

    Message MessageDtoToMessage(MessageDto messageDto);
}
