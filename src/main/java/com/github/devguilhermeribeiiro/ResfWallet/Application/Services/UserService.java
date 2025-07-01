package com.github.devguilhermeribeiiro.ResfWallet.Application.Services;

import java.util.Optional;
import java.util.UUID;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserRequestDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserResponseDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Exceptions.NotFoundException;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.UserRepositoryPort;

public class UserService {
    private UserRepositoryPort userRepository;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepository = userRepositoryPort;
    }

    public UserResponseDto getUser(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);

        User user = optionalUser.orElseThrow(() -> new NotFoundException("User not found"));

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userRepository.save(new User(
            userRequestDto.name(), 
            userRequestDto.email(), 
            userRequestDto.password()
        ));

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserResponseDto updateUser(UUID id, UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findById(id);

        User user = optionalUser.orElseThrow(() -> new NotFoundException("User not found"));
        user.setName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setPassword(userRequestDto.password());

        user = userRepository.update(user);

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }
    
    public byte deleteUser(UUID id) {
        return userRepository.deleteById(id);
    }
}
