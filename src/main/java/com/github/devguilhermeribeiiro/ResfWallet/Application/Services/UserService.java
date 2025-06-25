package com.github.devguilhermeribeiiro.ResfWallet.Application.Services;

import java.util.Optional;
import java.util.UUID;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserRequestDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserResponseDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Exceptions.NotFoundException;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Entities.User;
import com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.Outbound.UserRepositoryPort;

public class UserService {
    private UserRepositoryPort userRepository;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepository = userRepositoryPort;
    }

    public UserResponseDto getUser(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new NotFoundException("User not found.");
        }

        User user = optionalUser.get();

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

        if (!optionalUser.isPresent()) {
            throw new NotFoundException("User not found");
        }
        User user = optionalUser.get();
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
