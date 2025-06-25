package com.github.devguilhermeribeiiro.ResfWallet.Domain.Ports.Inbound;

import java.util.UUID;

import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserRequestDto;
import com.github.devguilhermeribeiiro.ResfWallet.Application.Dtos.UserResponseDto;

public interface UserUseCasePort {
    UserResponseDto getUser(UUID id);
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(UserRequestDto userRequestDto);
    void deleteUser(UUID id);
}
