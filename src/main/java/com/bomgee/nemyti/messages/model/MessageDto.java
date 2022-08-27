package com.bomgee.nemyti.messages.model;

import com.bomgee.nemyti.users.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;

    private String body;

    private LocalDateTime sendTime;

    private UserDto sender;
}
