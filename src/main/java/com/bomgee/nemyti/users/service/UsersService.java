package com.bomgee.nemyti.users.service;

import com.bomgee.nemyti.users.model.User;
import com.bomgee.nemyti.users.model.UserDto;
import com.bomgee.nemyti.users.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream().map(usersMapper::userToUserDto).collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        return usersMapper.userToUserDto(usersRepository.save(usersMapper.userDtoToUser(userDto)));
    }

    public UserDto getUserById(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("No such User"));
        return usersMapper.userToUserDto(user);
    }
}
