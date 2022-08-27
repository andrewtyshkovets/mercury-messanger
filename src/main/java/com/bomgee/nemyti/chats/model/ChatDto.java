package com.bomgee.nemyti.chats.model;

import com.bomgee.nemyti.messages.model.Message;
import com.bomgee.nemyti.messages.model.MessageDto;
import com.bomgee.nemyti.users.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

    private Long id;

    private UserDto sender;

    private UserDto receiver;

    private List<MessageDto> messages;
}
